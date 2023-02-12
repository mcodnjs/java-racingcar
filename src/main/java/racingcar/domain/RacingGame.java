package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.NumberGenerator;

public class RacingGame {
	private NumberGenerator numberGenerator;
	List<Car> cars = RacingCars.getCars();

	public RacingGame(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void moveCars() {
		cars.stream().forEach(car -> car.move(numberGenerator.getNumber()));
	}

	public List<String> getWinners() {
		final int[] maxPos = {0};
		cars.stream()
			.forEach(car ->
				maxPos[0] = car.getPosition() > maxPos[0]
					? car.getPosition()
					: maxPos[0]);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPos[0])
			.map(car -> car.getName())
			.collect(Collectors.toList());
	}

	public String getPositionToString() {
		StringBuilder sb = new StringBuilder();
		cars.stream()
			.forEach((car) -> sb.append(car.toString()).append("\n"));
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
