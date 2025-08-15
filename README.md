# 📈 Invest Portfolio System

## 📝 Descrição
O **Invest Portfolio System** é uma aplicação baseada em microserviços para gerenciamento de carteiras de investimentos.  
O objetivo é permitir que usuários criem e gerenciem múltiplas carteiras, cada uma contendo diferentes tipos de ativos como **Fundos Imobiliários (FI)**, **Ações** e **Criptomoedas**.  
O sistema também envia notificações sobre eventos relevantes e disponibiliza dados de forma centralizada via API Gateway.

---

## 🏗 Arquitetura

O sistema segue o modelo **Microservices Architecture**, onde cada serviço é responsável por uma função específica.  
A comunicação entre serviços é feita por **mensageria** usando Kafka, além de chamadas HTTP internas controladas via **Eureka Server** (Service Discovery).  
O **API Gateway** centraliza o acesso aos microsserviços, gerenciando autenticação e roteamento.

### Estrutura de Microsserviços

- **users-service** → Gerenciamento de usuários (CRUD, autenticação, autorização)
- **wallet-service** → Gerenciamento de carteiras e ativos
- **notifications-service** → Consumo de eventos via Kafka e envio de notificações
- **gateway** → Roteamento de requisições para os serviços internos
- **nameservice (Eureka)** → Registro e descoberta de serviços

---

## 🛠 Tecnologias Implementadas

### Backend
- **Java 17**
- **Spring Boot** (Web, Data JPA, Security)
- **Spring Cloud** (Eureka, Gateway, Config)
- **Apache Kafka** (mensageria, modo KRaft)
- **PostgreSQL** (armazenamento de dados)
- **Maven** (build e dependências)

### Infraestrutura
- **Docker** e **Docker Compose**
- **Eureka Server** (descoberta de serviços)
- **Kafka sem Zookeeper** (modo KRaft)
- **Volumes Docker** (persistência de dados)

### Frontend
- Framework JS a definir (React ou Vue)
- Consumo de APIs via API Gateway

---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/invest-portfolio-system.git
   cd invest-portfolio-system
