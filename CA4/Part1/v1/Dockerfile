FROM gradle:jdk21 as builder
LABEL author="Aline Emily"

WORKDIR /CA4/Part1

RUN git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git
WORKDIR /CA4/Part1/gradle_basic_demo
RUN gradle build
FROM openjdk:21-jdk-slim

COPY --from=builder /CA4/Part1/gradle_basic_demo/build/libs/*.jar /CA4/Part1/CA_PART1.jar

EXPOSE 59001

CMD [ "java", "-cp", "/CA4/Part1/CA_PART1.jar", "basic_demo.ChatServerApp", "59001"]