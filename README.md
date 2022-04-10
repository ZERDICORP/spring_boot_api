# spring_boot_api :smile_cat:
#### My first simple API with Spring Boot.
## How to start? :eyes:
> Work done in IntellijIDEA

#### 1. Make sure you have mariadb installed
```
$ mysql --version
mysql  Ver 15.1 Distrib 10.7.3-MariaDB, for Linux (x86_64) using readline 5.1
```

#### 2. Create a database with any name (I'll call it demo)
```
$ mysql -u root -p
MariaDB> create database demo;
MariaDB> exit;
```

#### 3. Add file `src/main/resources/application.properties` with the following content
> Replace all values between <>.
```
# Database Configuration
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/<DATABASE_NAME>?autoReconnect=true
spring.datasource.username=<DATABASE_USER>
spring.datasource.password=<DATABASE_USER_PASSWORD>

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDB103Dialect

# Spring Server setup
server.port=8000
server.error.include-message=always
```

#### 4. Now you can run the project :tada:
