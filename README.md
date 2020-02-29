# [CtCI](https://github.com/careercup/CtCI-6th-Edition)

[Cracking the Coding Interview](http://www.yes24.com/Product/Goods/44305533)를 공부한 내용을 정리

## 공부계획

- Cracking the Coding Interview 에 나와있는 문제들을 전부 푼다.
- Java 코드로 된 답지를 다운 받아서, 함수와 필수 로직부분만 지우고, TODO로 직접 작성한다.
- vscode로 작성하고, 터미널로 javac를 활용한다.
- Ch 01 - 10 까지만 한다.
- 원본 풀이는 master에 그대로 놔두고, feature에서 TODO로 지워서 작업한다.

## Command

```sh
// 자바 컴파일
javac -d ./Java/classes ./Java/**/*.java

// 컴파일된 class 실행
java -cp ./Java/classes ${packageName}.${className}

// 컴파일된 class 삭제
rm -rf ./Java/classes

// 원하는 곳의 디렉토리 자바만 빠르게 컴파일
javac -d ./Java/classes ./Java/Ch\ 01.\ Arrays\ and\ Strings/Q1_01_Is_Unique/*.java
```

## CtCI의 페이지

크롬으로 CtCI.pdf 를 열었을때를 기준으로,
목차에 적힌 페이지에 숫자 12를 더하면 된다.

## 스터디 계획

- 매주 화목토 오후 10시에 라이브 코딩 연습
  - 오후 10시: 정배형 퇴근시간 고려
  - 다른 일정과 상관없이, 습관적으로 하는 스터디
- 한 사람당 매주 CtCI의 2문제 라이브 코딩
  - 화(고정완), 목(전태준), 토(이정배)
  - 서로 겹치는 일이 없도록, 매주 토요일날 다음주에 무슨 문제 풀 건지 미리 의논하기
  - 한명이 라이브 코딩 interviewee, 나머지가 interviewer가 된다.
  - 결과: 매주 문제 6개씩 진도를 나가게 됨
- 시간이 없으면 일요일에 놀지말고, 2문제 미리 풀어두고, 설명 쉽게 주석 달아 놓자

## 사용툴

- Skype로 통화 및 화면 공유
