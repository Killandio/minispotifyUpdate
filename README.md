# MiniSpotify

Este projeto foi desenvolvido como parte de um trabalho acadêmico, com o objetivo de **integrar Java (Spring Boot) com banco de dados MySQL** e aplicar os **quatro tipos de relacionamentos entre entidades** no JPA/Hibernate:

- **1:1** → Usuário ↔ Perfil  
- **1:N** → Gênero ↔ Mídias  
- **N:1** → Mídia ↔ Gênero  
- **N:N** → Playlist ↔ Mídias  

O sistema simula uma versão simplificada do **Spotify**, permitindo cadastrar usuários, perfis, gêneros, mídias e playlists, além de gerenciar suas associações.

![license](https://img.shields.io/badge/license-MIT-green)
![java](https://img.shields.io/badge/Java-21-informational)
![spring](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)

## ✨ O que este projeto faz
- CRUD de usuários e perfis  
- CRUD de gêneros e mídias (cada mídia pertence a um gênero)  
- Playlists com dono e associação de mídias  
- Busca de mídias por gênero/termo  

## 🧱 Stack
- Java 21  
- Spring Boot 3  
- JPA/Hibernate  
- MySQL 8  

## ▶️ Como rodar localmente

**Pré-requisitos:** Java 21, Maven, MySQL 8

Crie o banco `minispotify` e ajuste `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minispotify?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Rodar:
```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`.

## 🗂️ Estrutura
```
src/
 ├─ main/java/...        # Controllers, Services, Repositories, Entities
 └─ main/resources/      # application.properties
```

## 📄 Licença
Este projeto está sob licença MIT. Veja [LICENSE](LICENSE).
