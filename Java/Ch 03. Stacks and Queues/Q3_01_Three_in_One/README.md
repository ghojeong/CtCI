# Q3_01_Three_in_One

- 문제 페이지: 110
- 풀이 페이지: 239

## Script

```script
javac -d ./Java/classes ./Java/CtCILibrary/CtCILibrary/*.java ./Java/Ch\ 03.\ Stacks\ and\ Queues/Q3_01_Three_in_One/*.java

java -cp ./Java/classes Q3_01_Three_in_One.QuestionA
java -cp ./Java/classes Q3_01_Three_in_One.QuestionB

java -cp ./Java/classes Q3_01_Three_in_One.QuestionGho
java -cp ./Java/classes Q3_01_Three_in_One.QuestionJvhe
```

## Output

### QuestionA

```txt
0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
10, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0,
10, 0, 0, 0, 20, 0, 0, 0, 30, 0, 0, 0,
10, 0, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
10, 11, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
10, 11, 12, 0, 20, 21, 0, 0, 30, 0, 0, 0,
10, 11, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
10, 11, 0, 0, 20, 21, 0, 0, 30, 31, 0, 0,
10, 11, 13, 0, 20, 21, 0, 0, 30, 31, 0, 0,
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 0, 0,
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 31, 0,
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 31, 32,
```

### QuestionB

```txt
0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
/// Pushing stack 0: 10
10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
/// Pushing stack 1: 20
10, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0,
/// Pushing stack 2: 30
10, 0, 0, 0, 20, 0, 0, 0, 30, 0, 0, 0,
/// Pushing stack 1: 21
10, 0, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
/// Pushing stack 0: 11
10, 11, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
/// Pushing stack 0: 12
10, 11, 12, 0, 20, 21, 0, 0, 30, 0, 0, 0,
/// Popping stack 0
10, 11, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0,
/// Pushing stack 2: 31
10, 11, 0, 0, 20, 21, 0, 0, 30, 31, 0, 0,
/// Pushing stack 0: 13
10, 11, 13, 0, 20, 21, 0, 0, 30, 31, 0, 0,
/// Pushing stack 1: 22
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 0, 0,
/// Pushing stack 2: 31
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 31, 0,
/// Pushing stack 2: 32
10, 11, 13, 0, 20, 21, 22, 0, 30, 31, 31, 32,
/// Pushing stack 2: 33
/// Expanding stack 2
/// Shifting 0
33, 10, 11, 13, 20, 21, 22, 0, 30, 31, 31, 32,
/// Pushing stack 2: 34
/// Expanding stack 2
/// Shifting 0
/// Shifting 1
33, 34, 10, 11, 13, 20, 21, 22, 30, 31, 31, 32,
/// Popping stack 1
33, 34, 10, 11, 13, 20, 21, 0, 30, 31, 31, 32,
/// Pushing stack 2: 35
/// Expanding stack 2
/// Shifting 0
/// Shifting 1
33, 34, 35, 10, 11, 13, 20, 21, 30, 31, 31, 32,
Final Stack: 33, 34, 35, 10, 11, 13, 20, 21, 30, 31, 31, 32,
```
