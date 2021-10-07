
## project name
- auto-complete
- Java version: jdk 11
- port: 12101
- repository
```
    git clone https://github.com/Desponia/auto-complete.git
```

## how to build
```
    ./gradlew bootJar
```
## how to run
```
     java -jar build/libs/auto-complete-0.0.1-SNAPSHOT.jar
```

## example
```
    curl http://localhost:12101/search/auto-complete/nike
```

## H2 console
```
    http://localhost:12101/musinsa_db
    url: jdbc:h2:mem:test
    username: admin
    password: 1234
```

## etc.
- h2 테이블 설계는 따로 디테일하게 하지 않고, collection 대신 사용할 수 있는 아주 간단한 테이블로 구성하였습니다.
