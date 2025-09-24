# 🎵 MiniSpotify

CRUD de **Usuários**, **Gêneros**, **Mídias** e **Playlists** (Spring Boot 3 + MySQL 8).

## ✨ Funcionalidades
- Usuários e Perfil (1:1)
- Gêneros
- Mídias (com tipo e duração) + vínculo a Gênero (N:1)
- Playlists (owner) + associação de Mídias (N:N)

## 🚀 Como rodar
**Pré-requisitos:** Java 21, Maven, MySQL 8.

1. Configure `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/minispotify?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=SUASENHA
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
