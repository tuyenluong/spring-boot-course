# 🚀 Setting Up MySQL in Docker & Configuring User Access

## 🛠 1. Pull the Latest MySQL Image
```sh
docker pull library/mysql:latest
```

## 🚀 2. Run MySQL Container
```sh
docker run --name=mysqlUser -p 3305:3306 \
  -e MYSQL_RANDOM_ROOT_PASSWORD=true \
  -e MYSQL_AUTHENTICATION_PLUGIN=caching_sha2_password \
  -e MYSQLEXIT -d library/mysql:latest
```

## 📝 3. Check MySQL Logs
```sh
docker logs mysqlUser
```
This will display the **generated root password**.

## 🔑 4. Get the Generated Password for Root User
Copy the **generated password** from the logs.

## 🎥 5. Enter the MySQL Container Shell
```sh
docker exec -it mysqlUser sh
```

## 🔗 6. Connect to MySQL
```sh
mysql -u root -p
```
📌 **Enter the generated password** when prompted.

## 🔄 7. Change Root Password
```sql
ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
FLUSH PRIVILEGES;
```

## 🔄 8. Restart the Container & Verify Root Login
```sh
docker restart mysqlUser
docker exec -it mysqlUser sh
mysql -u root -p
```
📌 Use the new password (`123456`) from Step 7.

---

## 👤 9. Create a New User (`jeremy`)
```sql
CREATE USER 'jeremy'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'jeremy'@'%';
ALTER USER 'jeremy'@'%' IDENTIFIED WITH caching_sha2_password BY '123456';
FLUSH PRIVILEGES;
```

---

## 📁 10. Generate Database & Data (Based on `scripts.sql`)
```sql
-- Only for root user
CREATE DATABASE IF NOT EXISTS <db_name>;
USE <db_name>;
```

---

## 🤍 11. Test Connection with Spring Boot
Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3305/<db_name>
spring.datasource.username=jeremy
spring.datasource.password=123456
```

Test MySQL connection:
```sql
USER 'jeremy'@'localhost' IDENTIFIED BY '123456';
```

---

## 🎉 **Done! Your MySQL setup in Docker is now ready for Spring Boot.**
