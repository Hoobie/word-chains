# word-chains

Kata19 solution: http://codekata.com/kata/kata19-word-chains/

## How to run
```bash
./gradlew build
java -cp build/classes/main:build/resources/main com.example.wordchains.Main cat dog
```

## Build with GraalVM's native-image
```bash
native-image -cp build/classes/main:build/resources/main com.example.wordchains.Main NativeWordChains -H:IncludeResources=".*/wordlist.txt\$"
```