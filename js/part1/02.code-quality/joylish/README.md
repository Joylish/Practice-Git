# 2. 코드 품질

## 🔮 이건 꼭 기억해야해!
1. call stack
2. BDD
3. 바벨과 웹팩 정의

## 🧐면접관처럼 질문할 목록
- 없음

## 👻 공부하면서 어렵거나 중요한 개념 정리
### 1) Chrome으로 디버깅하기
### 🦄 Callstack

  자바스크립트에서는 함수를 실행할 때 Call Stack에 저장하여 실행한다.

```javascript
  function third() {
    console.log("Three is called!");
  }

  function second() {
  third();
  }

  function first() {
  second();
  }

  function zero() {
  first();
  }

  zero();
```

- 함수 호출 순서
> zero → first → second → third
- 함수 실행 순서
> third ("Three is called!" 출력) → second → first → zero

### 2) 코딩 스타일

  팀원끼리 javascript 코딩컨벤션을 정할 때 고려하자!
  - 세미콜론
  
    : 코드 한 줄 끝날 때 세미콜론 붙이기
  - 중괄호
  - 가로 길이: 80-120자 추천
  - 들여쓰기
    - 가로: 스페이스 2개 vs 4개
    - 세로: 빈 줄을 넣어 코드 분리 (변수선언, 반복문, return)
  - 중첩레벨: 깊은 중첩문은 피하자! 
  
    continue, return으로 깊어지는 것 방지
  - 함수 위치

    코드를 먼저, 함수는 그 다음에 선언하기

### 3) Behavior Driven Development (BDD)
BDD = 테스트(test) + 문서(documentation) + 예시(example)
> Mocha – 핵심 테스트 프레임워크로, describe, it과 같은 테스팅 함수와 테스트 실행 관련 주요 함수를 제공
>
> Chai – 다양한 assertion을 제공해 주는 라이브러리
>
> Sinon – 함수의 정보를 캐내는 데 사용되는 라이브러리

BDD에선 만들어진 산출물을 다음과 같이 부른다.
- 명세서(specification)
- 스펙(spec)

 💥 테스트는 명확한 입력값, 출력값과 함께 여러 개의 it 블록으로 쪼개 작성하는 것이 좋다.
> 🤩 Why ?
>
> 실행 흐름이 복잡한 경우 에러가 발생하면 에러를 만든 입력값이 무엇이었는지를 일일이 확인해야 한다. 테스트 코드를 디버깅 해야 하는 웃픈 상황이 발생하기 때문이다.

### 4) 바벨
바벨은 트랜스파일러이다!

> 🤖 트랜스파일러
>
> 나는 코드를 재작성해주는 친구! 
>
> 자바스크립트 코드를 구 표준을 준수하는 코드로 바꿔준다.
> 
>🐋 웹팩(webpack)
> 나는 프로젝트 빌드 시스템!
> 모던 프로젝트 빌드 시스템은 코드가 수정될 때마다 자동으로 트랜스파일러를 동작시켜준다. 
