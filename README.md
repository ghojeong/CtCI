# [CtCI](https://github.com/careercup/CtCI-6th-Edition)

[Cracking the Coding Interview](http://www.yes24.com/Product/Goods/44305533)의 공부 자료

## 진행 상황

- 고정완(5/19 화): Ch 5. 문제 7번
- 전태준(5/21 목): Ch 5. 문제 8번
- 이정배(5/09 토): Ch 5. 문제 5번, 6번

## Study Plan

- [CtCI.pdf](./CtCI.pdf)에 나와있는 문제들을 푼다.
  - CtCI 문제가 아니라, 추천받은 문제를 라이브 코딩할 수도 있다.
  - 이 경우 미리 풀은 CtCI 문제를 gitHub에 올려두어야 한다.
- 일시: 매주 화목토 오후 10
  - 화(고정완), 목(전태준), 토(이정배)
  - 최대 1시간 (오후 10시 - 11시) 진행

## Command

```sh
// 자바 컴파일
javac -Xlint -d ./Java/classes ./Java/**/*.java

// 컴파일된 class 실행
java -cp ./Java/classes ${packageName}.${className}

// 컴파일된 class 삭제
rm -rf ./Java/classes && rm ./JUnit/*.class
```

## Tip

풀이순서

1. 메모장에 어떻게 구현할 건지 아이디어를 그린다.
2. 빅오를 계산한다.
3. 마지막에 코드를 구현한다.
