# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
  
## 기능 요구사항
- 입력(뷰)
    - [X] 자동차 이름 입력
      - [X] validate: 이름의 길이가 0이 아닌지
    - [X] 라운드 횟수 입력
      - [X] validate: 자연수가 입력되었는지

- 출력(뷰)
    - [X] 컨트롤 메세지 출력
        - [X] 자동차 이름 및 시도 횟수 입력 메시지
        - [X] 실행 결과 메시지
    - [X] 경주 실행 과정 출력
    - [X] 경주 실행 결과 출력

- 도메인
    - [X] 자동차 (Car)
      - [X] 전진 여부 판단하여 상태 업데이트
      - [X] 차의 위치를 문자열로 변환하는 기능(toString)
      - [X] validate: 자동차 이름이 5자 이하인지
    - [X] 경주에 참여하는 자동차들 (RacingCars)
        - [X] validate: 중복된 이름을 가진 차가 있는지
    - [X] 자동차 경주 게임 (RacingGame)
        - [X] 난수 생성 기능
        - [X] 모든 차의 진행 상황을 갱신
        - [X] 우승자들을 반환하는 기능
        - [X] 모든 차의 위치를 문자열로 변환하는 기능


- ~~저장소~~
    - [X] ~~자동차 진행 저장소~~
        - [X] ~~validate: 중복된 이름을 가진 차가 있는지~~

- ~~서비스~~
    - [X] ~~난수 생성 기능~~
    - [X] ~~모든 차의 진행 상황을 갱신~~
    - [X] ~~우승자들을 반환하는 기능~~
    - [X] ~~모든 차의 위치를 문자열로 변환하는 기능~~

- 컨트롤러
    - [X] 컨트롤 메세지 출력 및 자동차, 횟수 입력 받기 
    - [X] 시도횟수만큼 서비스 로직 수행

## 리팩토링 
- [X] MVC 패턴 적용 (CarRepository, CarService -> RacingCars, RacingGame)
- [X] 우승자 구하는 로직 변경
- [X] 변수 및 메서드 네이밍
- [ ] 자동차 위치 출력 역할 담당 클래스 고민
- [ ] 자동차의 Name, Position 원시값 포장 고민
