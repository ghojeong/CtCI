# Q4_01_Route_Between_Nodes

- 문제 페이지: 121
- 풀이 페이지: 253

## Command

```sh
javac -Xlint -d ./Java/classes ./Java/Ch\ 04.\ Trees\ and\ Graphs/Q4_01_Route_Between_Nodes/**/*.java

java -cp ./Java/classes Q4_01_Route_Between_Nodes.Question

java -cp ./Java/classes Q4_01_Route_Between_Nodes.ghojeong.Question
```

## Output

### Question

```txt
true
```

### ghojeong.Question

#### 그래프 모양(Complete Binary Tree)

```txt
          0
    1           2
 3    4      5      6
7 8  9 10  11 12  13 14
```

```txt
BfsRoute 0->10: [0, 1, 4, 10]
Visited History: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
BfsRoute 1->2: null
Visited History: [1, 3, 4, 7, 8, 9, 10]

DfsRoute 0->10: [0, 1, 4, 10]
Visited History: [0, 1, 2, 5, 6, 13, 14, 11, 12, 3, 4, 9]
DfsRoute 1->2: null
Visited History: [1, 3, 4, 9, 10, 7, 8]

RecDfsRoute 0->10: [0, 1, 4, 10]
Visited History: [0, 1, 3, 7, 8, 4, 9, 2, 5, 11, 12, 6, 13, 14]
RecDfsRoute 1->2: null
Visited History: [1, 3, 7, 8, 4, 9, 10]
```
