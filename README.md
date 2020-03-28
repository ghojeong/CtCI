# [CtCI](https://github.com/careercup/CtCI-6th-Edition)

[Cracking the Coding Interview](http://www.yes24.com/Product/Goods/44305533)의 공부 자료

## 진도 상황

README.md의 유무로 풀은 문제인지 아닌지 확인한다.

- 고정완(3/24 화): Ch 04. 문제 1번
- 전태준(3/26 목): Ch 04. 문제 2번
- 이정배(3/28 토): Ch 04. 문제 3번

(Ch 04. 트리와 그래프 해법) 챕터는 건너 뛰지 말고, 나온 문제는 모두 풀도록 하자.

## 공부 계획

- [CtCI.pdf](./CtCI.pdf)에 나와있는 문제들을 푼다.
- Java 코드로 된 답지를 다운 받아서, 함수와 필수 로직부분만 지우고, TODO로 라이브 코딩한다.

## Command

```sh
// 자바 컴파일
javac -Xlint -d ./Java/classes ./Java/**/*.java

// 컴파일된 class 실행
java -cp ./Java/classes ${packageName}.${className}

// 컴파일된 class 삭제
rm -rf ./Java/classes && rm ./JUnit/*.class
```

## 스터디 계획

- 사용툴: [Skype](https://skype.daesung.com/main.asp)
- 일시: 매주 화목토 오후 10
  - 화(고정완), 목(전태준), 토(이정배)
  - 최대 1시간 (오후 10시 - 11시) 진행

## Tip

- 서로 겹치는 일이 없도록, 매주 토요일날 무슨 문제 풀 건지 미리 의논하기
- 시간이 없으면 일요일에 놀지말고, 미리 풀어서 설명 쉽게 주석 달아 놓자

## 회의 내용

- Ch.01 부터 10 까지 반복 순회
- 매주 챕터 하나씩 진도나가기
- 먼저 주석 부터 다 써놓고, TODO를 하나하나 구현해나가기
- 풀이가 끝나고 BigO 계산하고, 개선할 수 있는 부분 피드백 주기
