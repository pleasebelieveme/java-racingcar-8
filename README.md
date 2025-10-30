# 🏎️ 자동차 경주 게임 (java-racingcar-precourse)

## 📖 프로젝트 소개

> 우아한테크코스 프리코스 2주차 미션입니다.
> 
> 여러 대의 자동차가 무작위로 전진하며 경주하는 간단한 콘솔 게임을 구현했습니다.

### 주요 기능
- 🚗 여러 대의 자동차 동시 경주
- 🎲 무작위 전진 조건 (0~9 중 4 이상)
- 🏆 우승자 판별 (단독/공동 우승 지원)
- ✅ 입력값 검증 및 예외 처리

---

## 🚀 실행 방법

### 요구사항
- Java 21
- Gradle

### 실행
```bash
./gradlew run
```

### 입출력 예시

**입력:**
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5
```

**출력:**
```
실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

---

## 🛠️ 기술 스택

- **Language:** Java 21
- **Build Tool:** Gradle
- **Testing:** JUnit 5, AssertJ
- **Library:** camp.nextstep.edu.missionutils

---

## 📦 패키지 구조
```
src/main/java/racingcar/
├── Application.java              # 프로그램 진입점
├── domain/                       # 핵심 비즈니스 로직
│   ├── Car.java                 # 자동차 객체 (이름, 위치)
│   └── Cars.java                # 여러 자동차 관리 및 우승자 판별
├── service/                      # 게임 진행 조율
│   └── RacingGameService.java
├── view/                         # 입출력 처리
│   ├── InputView.java           # 사용자 입력
│   └── OutputView.java          # 결과 출력
├── validator/                    # 입력 검증
│   └── InputValidator.java
└── util/                         # 유틸리티
    └── RandomGenerator.java      # 무작위 값 생성 및 전진 조건
```

---

## ⚙️ 기능 구현 목록

### 1. 도메인 객체 구현

#### 1.1 Car 객체 구현

**정상 케이스:**
- [x] 자동차 이름과 초기 위치(0)를 저장한다
- [x] 전진 명령(true)을 받으면 위치가 1증가한다
- [x] 정지 명령(false)을 받으면 위치가 유지된다
- [x] 현재 위치를 반환한다

**커밋:** `feat(domain): Car 객체 기본 기능 구현` ✅

#### 1.2 Cars 객체 구현

**정상 케이스:**
- [x] 여러 Car 객체를 관리한다
- [x] 모든 자동차를 한 번씩 이동시킨다
- [x] 가장 많이 전진한 자동차(들)를 우승자로 판별한다

**예외 케이스:**
- [x] 빈 리스트로 생성 시 예외 발생

**커밋:** `feat(domain): Cars 객체 구현` ✅

---

### 2. 입력 검증 구현

#### 2.1 자동차 이름 길이 검증

**정상 케이스:**
- [x] 이름이 5자 이하면 통과

**예외 케이스:**
- [x] 이름이 5자 초과 시 IllegalArgumentException 발생

**커밋:** `feat(validator): 자동차 이름 길이 검증 구현` ✅

#### 2.2 자동차 이름 유효성 검증

**정상 케이스:**
- [x] 유효한 이름들이면 통과

**예외 케이스:**
- [x] 이름이 null이면 예외 발생
- [x] 이름이 빈 문자열이면 예외 발생
- [x] 중복된 이름이 있으면 예외 발생

**커밋:** `feat(validator): 이름 빈 값 및 중복 검증 구현` ✅

#### 2.3 이동 횟수 검증

**정상 케이스:**
- [x] 1 이상의 정수면 통과

**예외 케이스:**
- [x] 0 이하면 예외 발생
- [x] 숫자가 아니면 예외 발생
- [x] null이면 예외 발생

**커밋:** `feat(validator): 이동 횟수 검증 구현` ✅

---

### 3. 랜덤 기반 전진 로직

#### 3.1 무작위 값 생성 및 전진 조건

**정상 케이스:**
- [x] 0~9 사이의 무작위 값 생성
- [x] 4 이상이면 true(전진) 반환
- [x] 4 미만이면 false(정지) 반환

**커밋:** `feat(util): 전진 조건 판별 유틸 구현` ✅

---

### 4. 입출력 기능

#### 4.1 자동차 이름 입력
- [x] 입력 안내 메시지 출력
- [x] 쉼표(,) 기준으로 이름 분리
- [x] 각 이름의 공백 제거

**커밋:** `feat(view): 자동차 이름 입력 기능 구현` ✅

#### 4.2 이동 횟수 입력
- [x] 입력 안내 메시지 출력
- [x] 문자열을 정수로 변환

**커밋:** `feat(view): 이동 횟수 입력 기능 구현` ✅

#### 4.3 자동차 이동 상태 출력
- [x] "실행 결과" 헤더 출력
- [x] 각 자동차를 "이름 : ---" 형식으로 출력
- [x] 라운드마다 빈 줄 추가

**커밋:** `feat(view): 이동 상태 출력 기능 구현` ✅

#### 4.4 우승자 출력
- [x] 단독 우승자 출력
- [x] 공동 우승자를 쉼표(,)로 구분하여 출력

**커밋:** `feat(view): 우승자 출력 기능 구현` ✅

---

### 5. 게임 진행 서비스

#### 5.1 RacingGameService 구현
- [x] 입력 → 검증 → 실행 → 출력 흐름 조율
- [x] n번의 라운드 반복 실행
- [x] 각 라운드마다 자동차 이동 및 상태 출력
- [x] 우승자 판별 및 출력

**커밋:** `feat(service): RacingGameService 게임 진행 로직 구현` ✅

---

### 6. 메인 실행

#### 6.1 Application 진입점
- [x] RacingGameService 실행
- [x] 예외 발생 시 프로그램 자동 종료

**커밋:** `feat(app): Application 메인 실행 구현` ✅

---

## 🏗️ 아키텍처

- **레이어드 아키텍처** (Layered Architecture) 기반
- **Package by Layer** 방식
- **Inside-Out 개발** (Domain → Validator → Util → View → Service → Application)
```
┌─────────────────┐
│  Application    │ (진입점)
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│    Service      │ (조율)
└────┬────────────┘
     │
     ├──────────┐
     ▼          ▼
┌─────────┐  ┌──────────┐
│ Domain  │  │   View   │
└─────────┘  └──────────┘
     ▲          ▲
     │          │
┌────┴──────────┴────┐
│    Validator       │
└────────────────────┘
```

---

## ✅ 프로그래밍 요구사항 준수

- [x] JDK 21에서 실행 가능
- [x] indent depth 2 이하
- [x] 3항 연산자 미사용
- [x] 함수(메서드) 작게 분리
- [x] JUnit 5, AssertJ 테스트 작성
- [x] `Randoms.pickNumberInRange()` 사용
- [x] `Console.readLine()` 사용
- [x] 값 하드코딩 지양 (상수 활용)

---

## 🧪 테스트

### 테스트 실행
```bash
./gradlew test
```

### 테스트 구조
```
src/test/java/racingcar/
├── domain/
│   ├── CarTest.java
│   └── CarsTest.java
├── validator/
│   └── InputValidatorTest.java
├── util/
│   └── RandomGeneratorTest.java
├── view/
│   └── OutputViewTest.java
└── service/
    └── RacingGameServiceTest.java
```

---

## 💭 회고

### 가장 오래 고민했던 부분
- 패키지 구조 설계 (레이어드 아키텍처 적용)
- 테스트 가능한 코드 작성 (의존성 분리)

### 실패했지만 의미 있었던 도전
- TDD방식이 생소해 GPT에게 너무 많이 의존한 부분

### 다음에 다르게 접근하고 싶은 부분
- 정말 테스트먼저 작성하고 구현하는 연습을 해야할 것 같다

---

## 📚 학습 내용

- 레이어드 아키텍처
- TDD (Test-Driven Development)
- 단일 책임 원칙 (SRP)
- 메서드 분리 및 indent depth 관리
- JUnit 5, AssertJ 활용

