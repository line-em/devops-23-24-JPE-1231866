FROM gradle:jdk21 as builder
LABEL author="Aline Emily"

WORKDIR /CA4/Part2
RUN git clone https://github.com/line-em/devops-23-24-JPE-1231866.git

WORKDIR /CA4/Part2/devops-23-24-JPE-1231866/CA2/Part2
RUN gradle build
EXPOSE 8080

COPY *.jar /CA4/Part2/

CMD [ "gradle", "bootRun" ]

