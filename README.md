# [CtCI](https://github.com/careercup/CtCI-6th-Edition)

[Cracking the Coding Interview](http://www.yes24.com/Product/Goods/44305533)의 공부 자료

## Unix Command

```sh
// 자바 컴파일
javac -Xlint -d ./Java/classes ./Java/**/*.java

// 컴파일된 class 실행
java -cp ./Java/classes ${packageName}.${className}

// 컴파일된 class 삭제
rm -rf ./Java/classes && rm ./JUnit/*.class
```

## CMD Command

```sh
// 자바 컴파일
javac -Xlint ./*.java

// 컴파일된 class 실행
java ${packageName}.${className}

// 컴파일된 class 삭제
del /s *.class
```
