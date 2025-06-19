###############################################
#Arquivo Dockerfile
#O Dockerfile tem como objetivo principal definir, de forma automatizada e versionada, o ambiente necessário para construir 
#uma imagem Docker que possa executar uma aplicação. Ele contém uma série de instruções que informam ao Docker como montar 
#essa imagem, incluindo qual base utilizar, quais arquivos copiar, quais comandos executar para instalar dependências e 
#configurar a aplicação, além de definir o comando padrão para iniciar o software.
#
#Assim, o Dockerfile permite criar ambientes padronizados, portáteis e reproduzíveis, facilitando o desenvolvimento, testes, 
#implantação e distribuição da aplicação em qualquer lugar que suporte Docker.
###############################################

# Usa uma imagem base leve com o JDK 17 da Temurin (Adoptium), baseada no Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho dentro do container como /app
WORKDIR /app

# Copia o JAR gerado pelo Maven da máquina host para o diretório /app do container
COPY target/conectar-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de entrada para rodar o JAR usando o Java
ENTRYPOINT ["java", "-jar", "app.jar"]