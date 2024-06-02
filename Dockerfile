# Usa una imagen base de JDK para ejecutar la aplicación
FROM eclipse-temurin:17-jdk-jammy

# Configura el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY build/libs/SpringTest-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]