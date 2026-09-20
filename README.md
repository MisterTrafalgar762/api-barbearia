# 💈 api-barbearia

> API RESTful desenvolvida em Spring Boot para gerenciamento e agendamento de serviços em barbearias, com confirmação automatizada via e-mail.

---

## 👥 Equipe do Projeto

* **Yan Gonçalves** – Módulo de Serviços, Configuração e Integração do Spring Mail, Documentação e Git.
* **Milena Dias** – Módulo de Clientes e Agendamentos.
* **Verônica** – Módulo de Barbeiros e Modelagem do Banco de Dados.

---

# Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Framework:** Spring Boot
* **Persistência:** Spring Data JPA / Hibernate
* **Bancos de Dados:** MySQL (Produção via XAMPP) e H2 Database (Testes em Memória)
* **Comunicação:** Spring Mail (`spring-boot-starter-mail` via Gmail SMTP)
* **Validação:** Bean Validation / Hibernate Validator (`spring-boot-starter-validation`)
* **Gerenciador de Dependências:** Maven

---

## ⚙️ Como Executar a Aplicação

### 1. Pré-requisitos
* Java JDK 17 ou superior instalado.
* XAMPP com o serviço **MySQL** ativo na porta padrão (`3306`).

### 2. Configuração do Ambiente
Antes de iniciar, certifique-se de preencher as propriedades locais no arquivo `src/main/resources/application.properties`:
* **Banco de Dados:** Ajuste as configurações de conexão do MySQL conforme o seu ambiente local.
* **Envio de E-mail (SMTP):** Defina o endereço de remetente e a chave de autenticação do aplicativo (`spring.mail.username` e `spring.mail.password`).

### 3. Rodar o Projeto
No terminal, dentro da pasta da aplicação:
```powershell
.\mvnw.cmd spring-boot:run