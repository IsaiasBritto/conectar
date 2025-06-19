# 📦 Projeto: Integração Spring Boot com ELK Stack + Prometheus/Grafana

Este projeto demonstra uma aplicação Java Spring Boot integrada com a stack **ELK (Elasticsearch, Logstash, Kibana)** para centralização de logs e com **Prometheus + Grafana** para monitoramento de métricas.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5**
- **Elasticsearch 8.13.4**
- **Logstash 8.13.4**
- **Filebeat 8.13.4**
- **Kibana 8.13.4**
- **Prometheus (latest)**
- **Grafana (latest)**
- **Docker & Docker Compose**
- **Micrometer + Spring Boot Actuator**
- **Logback + Logstash Encoder**
- **Monitoramento com o SonarQube**

---

## 📂 Estrutura do Projeto

```
├── conectar/                         # Projeto Spring Boot
│   ├── src/main/java                 # Código-fonte da aplicação
│   ├── src/main/resources
│   │   ├── application.yml           # Configurações Spring
│   │   ├── logback-spring.xml        # Configuração de logs
│   └── pom.xml                       # Dependências Maven
│
├── config/
│   ├── filebeat.yml                 # Configuração do Filebeat
│   ├── prometheus.yml              # Configuração do Prometheus
│
├── logstash/
│   ├── config/logstash.yml         # Configuração principal do Logstash
│   └── pipeline/logstash.conf      # Pipeline de entrada/saída do Logstash
│
├── logs/                           # Pasta de logs monitorada pelo Filebeat
│
├── Dockerfile                      # Dockerfile da aplicação Spring Boot
├── docker-compose.yml             # Orquestração dos serviços
└── README.md                       # Este arquivo
```

---

## ⚙️ Como Executar

### Pré-requisitos

- Docker e Docker Compose instalados.

### Passos

```bash
# 1. Clone o projeto
git clone https://github.com/IsaiasBritto/conectar.git
cd conectar

# 2. Gere o JAR da aplicação
cd conectar
mvn clean package -DskipTests

# 3. Volte ao diretório raiz e suba os containers
cd ..
docker-compose up --build
```

---

## 🔍 Acessos e Endpoints

| Serviço        | URL                                 |
|----------------|--------------------------------------|
| API Spring     | http://localhost:8080/api/product    |
| Kibana         | http://localhost:5601                |
| Elasticsearch  | http://localhost:9200                |
| Prometheus     | http://localhost:9090                |
| Grafana        | http://localhost:3000 (admin/admin)  |

---

## 📈 Logs e Métricas

- Os logs da aplicação são enviados via Logback para o **Logstash**, que encaminha ao **Elasticsearch**.
- O **Kibana** permite visualizar os logs com filtros e dashboards.
- Métricas customizadas são expostas em `/actuator/prometheus` e coletadas pelo **Prometheus**.
- O **Grafana** exibe dashboards com as métricas da API.

---

## ✅ Exemplos de Testes da API

### Criar produto
```bash
curl -X POST http://localhost:8080/api/product  -H "Content-Type: application/json"  -d '{"id":"1", "name":"Produto A", "price":99.90}'
```

### Buscar produto por nome
```bash
curl http://localhost:8080/api/product/name/Produto%20A
```

---

## 🛠️ Arquivos Importantes

### `Dockerfile`

Responsável por empacotar a aplicação Spring Boot em uma imagem container.

### `docker-compose.yml`

Orquestra todos os serviços do ecossistema (Spring Boot, ELK, Prometheus, Grafana).

### `logback-spring.xml`

Define o padrão de log e o envio para o Logstash via socket TCP.

### `filebeat.yml`

Monitora os logs da aplicação (pasta `/logs`) e envia para o Logstash.

---

## 🧪 Testes

A aplicação possui testes automatizados com `SpringBootTest`. Execute com:

```bash
mvn test
```

---

## 👨‍💻 Autor

- **Isaias Silva de Britto** – [LinkedIn](https://linkedin.com/in/isaiasbritto)  
- Repositório GitHub: [github.com/IsaiasBritto/conectar](https://github.com/IsaiasBritto/conectar)

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

