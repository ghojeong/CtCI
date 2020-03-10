# Q1_02_Check_Permutation

- 문제 페이지: 106
- 풀이 페이지: 220

## 읽을거리

[List 인터페이스의 구현체 비교](https://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220991199432&redirect=Dlog&widgetTypeCall=true&directAccess=false)

## Script

```script
javac -d ./Java/classes ./Java/CtCILibrary/CtCILibrary/*.java ./Java/Ch\ 02.\ Linked\ Lists/Q2_01_Remove_Dups/*.java

java -cp ./Java/classes Q2_01_Remove_Dups.QuestionA
java -cp ./Java/classes Q2_01_Remove_Dups.QuestionB
java -cp ./Java/classes Q2_01_Remove_Dups.QuestionC
java -cp ./Java/classes Q2_01_Remove_Dups.Tester

javac -Xlint -d ./Java/classes ./Java/Ch\ 02.\ Linked\ Lists/Q2_01_Remove_Dups/QuestionGho.java

java -cp ./Java/classes Q2_01_Remove_Dups.QuestionGho
```

## Output

### QuestionA

```txt
0->1->0->1->0->1->0->1
0->1
```

### QuestionB

```txt
0->1->0->1->0->1->0->1
```

### QuestionC

```txt
0->1->0->1->0->1->0->1
```

### Tester

```txt
0->1->0->1->0->1->0->1
0->1
0->1
0->1
```
