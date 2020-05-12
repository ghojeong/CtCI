# Q5_03_Flip_Bit_to_Win

- 문제 페이지: 128
- 풀이 페이지: 290

## Command

```sh
javac -Xlint -d ./Java/classes ./Java/Ch\ 05.\ Bit\ Manipulation/Q5_03_Flip_Bit_to_Win/*.java

java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.QuestionA
java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.QuestionB
java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.QuestionC
java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.QuestionD
java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.Tester
```

```sh
javac -Xlint -d ./Java/classes ./Java/Ch\ 05.\ Bit\ Manipulation/Q5_03_Flip_Bit_to_Win/ghojeong/*.java

java -cp ./Java/classes Q5_03_Flip_Bit_to_Win.ghojeong.Question
```

## Output

### QuestionA

```txt
1111111111111111111111111111111
32
```

### QuestionB

```txt
11011101111
8
```

### QuestionC

```txt
1111111111111111111111111111111
32
```

### QuestionD

```txt
-1: 32, 32 true
2147483647: 32, 32 true
-10: 31, 31 true
0: 1, 1 true
1: 2, 2 true
15: 5, 5 true
1775: 8, 8 true
```

### Tester

```txt
SUCCESS: -2147483648 -> -2147482648
SUCCESS: 2147481314 -> -2147480649
SUCCESS: -10000 -> 10000
```
