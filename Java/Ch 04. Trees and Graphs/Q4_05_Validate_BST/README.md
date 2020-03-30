# Q4_05_Validate_BST

- 문제 페이지: 122
- 풀이 페이지: 257

## Command

```sh
javac -Xlint -d ./Java/classes ./Java/CtCILibrary/CtCILibrary/*.java ./Java/Ch\ 04.\ Trees\ and\ Graphs/Q4_05_Validate_BST/*.java

java -cp ./Java/classes Q4_05_Validate_BST.Question
java -cp ./Java/classes Q4_05_Validate_BST.QuestionB
```

## Output

### Question

```txt
true
test cases for equals condition.
   2
  / \
 /   \
 2   3
      \
      4

should be true: true
   2
  / \
 /   \
 1   2
      \
      4

should be false: false

```

### QuestionB

```txt
       6
      / \
     /   \
    /     \
   /       \
   3       13
  / \     / \
 /   \   /   \
 -2147483648   5   10   15
              \
              2147483647

true

```
