package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racingcar.utils.NumberGenerator;

class RacingGameTest {
	class ZeroGenerator implements NumberGenerator {
		@Override
		public int getNumber() {
			return 0;
		}
	}

	class NineGenerator implements NumberGenerator {
		@Override
		public int getNumber() {
			return 9;
		}
	}

	ZeroGenerator zeroGenerator = new ZeroGenerator();
	NineGenerator nineGenerator = new NineGenerator();
	RacingGame racingGame;

	@BeforeEach
	void tearDown() {
		RacingCars.clear();
		RacingCars.add(new Car("woowa"));
		RacingCars.add(new Car("tech"));
	}

	@Test
	@DisplayName("Repository에 저장된 차들의 위치를 문자열로 반환해야 한다.")
	void getPositionToStringTest() {
		racingGame = new RacingGame(zeroGenerator);

		String expected = "woowa : -\ntech : -";
		assertThat(racingGame.getPositionToString()).isEqualTo(expected);
	}

	@Nested
	class CarsMovementTest {
		@Test
		@DisplayName("모든 차의 위치가 이동해야 한다.")
		void moveAllCarsTest() {
			RacingCars.add(new Car("code"));
			racingGame = new RacingGame(nineGenerator);
			racingGame.moveCars();

			String expected = "woowa : --\ntech : --\ncode : --";
			assertThat(racingGame.getPositionToString()).isEqualTo(expected);
		}

		@Test
		@DisplayName("모든 차의 위치가 변하지 않아야 한다.")
		void moveNoneCarsTest() {
			RacingCars.add(new Car("code"));
			racingGame = new RacingGame(zeroGenerator);
			racingGame.moveCars();

			String expected = "woowa : -\ntech : -\ncode : -";
			assertThat(racingGame.getPositionToString()).isEqualTo(expected);
		}
	}

	@Nested
	class WinnerTest {
		@Test
		@DisplayName("가장 많이 전진한 자동차가 우승자여야 한다.")
		void getWinnersTest() {
			assertThat(RacingCars.getCars().size()).isEqualTo(2);
			racingGame = new RacingGame(nineGenerator);
			racingGame.moveCars();

			RacingCars.add(new Car("code"));
			assertThat(racingGame.getWinners()).containsExactly("woowa", "tech");
		}
	}
}
