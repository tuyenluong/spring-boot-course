1. docker pull library/mysql:latest
2. docker run --name=mysqlUser -p 3305:3306 -e MYSQL_RANDOM_ROOT_PASSWORD=true -e MYSQL_AUTHENTICATION_PLUGIN=caching_sha2_password -e MYSQLEXIT -d library/mysql:latest
3. docker logs mysqlUser
4. Get the GENERATED PASSWORD for the root user
5. docker exec -it mysqlUser sh
6. mysql -u root -p
7. Enter GENERATED PASSWORD after get the logs from 'docker logs mysqlUser'
8. alter user 'root'@'localhost' identified by '123456';
9. FLUSH PRIVILEGES;
10. Restart container again and check the root user with new password from step 5 (docker restart mysqlUser)
11. CREATE USER 'jeremy'@'%' IDENTIFIED BY '123456'; 
12. GRANT ALL PRIVILEGES ON *.* TO 'jeremy'@'%';
12. ALTER USER 'jeremy'@'%' IDENTIFIED WITH caching_sha2_password BY '123456';
13. FLUSH PRIVILEGES;
13. Based on the scripts.sql follow steps below to generate data:
   1. CREATE DATABASE IF NOT EXISTS <db_name>; only for root user
   2. USE <db_name>; only for root user
15. Test connect with the new user and host with Spring setup: USER 'jeremy'@'localhost' IDENTIFIED BY '123456';

