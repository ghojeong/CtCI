# CtCI를 JUnit 으로 테스트하기

[JUnit4 공식문서](https://github.com/junit-team/junit4/wiki/Getting-started)

## Command

```sh
cd ./JUnit

javac -Xlint -cp .:junit-4.13.jar:hamcrest-core-1.3.jar ${ClassName}Test.java

java -cp .:junit-4.13.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore ${ClassName}Test
```

## 취지

고정완이 CtCI 공부를 통해 얻고 싶은 것은 아래 3가지이다.

- 알고리즘 공부
- Java 공부
- TDD 연습

단순히 코딩테스트를 통과하는 것을 넘어서, 실무에 활용할 수 있는 방향으로 시간을 쏟고 싶다.

## AS-IS

- 아직까지는 단일 클래스만을 빌드하는 수준이라, 하나의 프로젝트로써 관리할 필요성을 못 느끼겠다.
- 개발 속도와 빌드 속도를 빠르게 하기 위해, 빌드툴을 사용하지 않기로 했다.
- 따라서 javac 를 통해서 빌드할 수 있는 JUnit4를 활용한다.

## TO-BE

gradle 빌드툴을 활용해 [JUnit5](https://junit.org/junit5/docs/current/user-guide/)로 리팩토링
