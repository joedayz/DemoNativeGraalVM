FROM eclipse-temurin:17-jre as builder
WORKDIR application
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jre
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

# Copiar custom.security dentro del contenedor
COPY src/main/resources/custom.security /application/config/custom.security

# Configurar la JVM para usar custom.security
ENTRYPOINT ["java", "-Djava.security.properties=/application/config/custom.security", "org.springframework.boot.loader.launch.JarLauncher"]


