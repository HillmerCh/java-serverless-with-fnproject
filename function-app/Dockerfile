FROM fnproject/fn-java-fdk:jre11-1.0.85
WORKDIR /function
COPY target/function-app-1.0-SNAPSHOT.jar /function/app/
CMD ["demo.MyFunction::handleRequest"]