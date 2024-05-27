FROM openjdk:21-jdk-slim
LABEL author="Aline Emily"

WORKDIR /CA4/Part1

COPY ./*.jar /CA4/Part1/CA_PART1.jar

EXPOSE 59001

CMD ["java", "-cp", "/CA4/Part1/CA_PART1.jar", "basic_demo.ChatServerApp", "59001"]