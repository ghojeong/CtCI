# Q4_04_Check_Balanced

- 문제 페이지: 122
- 풀이 페이지: 256

## Script

```sh
javac -Xlint -d ./Java/classes ./Java/CtCILibrary/CtCILibrary/*.java ./Java/Ch\ 04.\ Trees\ and\ Graphs/Q4_04_Check_Balanced/*.java

java -cp ./Java/classes Q4_04_Check_Balanced.QuestionBrute
java -cp ./Java/classes Q4_04_Check_Balanced.QuestionImproved
```

## Output

### QuestionBrute

```txt
Root? 5
Is balanced? true
Root? 10
Is balanced? false
```

### QuestionImproved

```txt
Is balanced? true
Is balanced? false
```