#!/bin/sh

echo "Aguardando Elasticsearch em elasticsearch:9200..."

# Aguarda o Elasticsearch responder
while ! nc -z elasticsearch 9200; do
  echo "Elasticsearch ainda não está disponível. Aguardando..."
  sleep 3
done

echo "Elasticsearch está disponível! Iniciando aplicação..."
exec java -jar app.jar
