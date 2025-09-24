# 🎵 MiniSpotify  

CRUD de **Usuários**, **Perfis**, **Gêneros**, **Mídias** e **Playlists** (Spring Boot 3 + MySQL 8).  

![Java](https://img.shields.io/badge/Java-21-blue)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)  
![Status](https://img.shields.io/badge/Status-Entrega%20Completa-yellow)  

---

## ✨ Funcionalidades  
- Usuários e Perfil (1:1)  
- Gêneros musicais  
- Mídias (com tipo e duração) vinculadas a Gêneros (N:1)  
- Playlists (com dono) e associação de Mídias (N:N)  

---

## 🚀 Como rodar localmente  

### ✅ Pré-requisitos
- **Java 21**  
- **Maven**  
- **MySQL 8**  

### ⚙️ Configuração do `application.properties`  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minispotify?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=SENHA_AQUI
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
