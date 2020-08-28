# Apache Maven

**Java계열에서 대표적인 load package manager**

javascript 계열에서 대표적인 load package manager는 npm

[mongo java driver](https://mongodb.github.io/mongo-java-driver/)

[maven repository](https://mvnrepository.com/) 에서 **mongo java driver** 검색

![image-20200828131304996](C:\Users\IMPlay\Desktop\TIL\images\mvnrepo1.png)

![image-20200828131430702](C:\Users\IMPlay\Desktop\TIL\images\mvnrepo2.png)

![image-20200828131523631](C:\Users\IMPlay\Desktop\TIL\images\mvnrepo3.png)



#### Maven 설정 방법 2가지

1. 기존 Java project를 Maven project로 변환(convert)
2. 처음부터 Maven project로 생성

그러면 pom.xml 파일 생성된다!



이클립스에서 1번 하기

![image-20200828133615763](C:\Users\IMPlay\Desktop\TIL\images\mavenConvert1.png)

![image-20200828133726792](C:\Users\IMPlay\Desktop\TIL\images\mavenConvert2.png)

![image-20200828133941166](C:\Users\IMPlay\Desktop\TIL\images\mavenConvert3.png)

dependency 추가 이후 재시작(ctrl+f5)하면 추가된 dependency가 컴파일이 되면서 maven dependencies에 추가된다.

![image-20200828134423655](C:\Users\IMPlay\Desktop\TIL\images\mvnrepo4.png)



------



![image-20200828134159436](C:\Users\IMPlay\Desktop\TIL\images\newMaven1.png)



![image-20200828134247831](C:\Users\IMPlay\Desktop\TIL\images\newMaven2.png)



#### Maven에서 라이브러리 설치 방식

pom.xml에 dependency 추가

.m2