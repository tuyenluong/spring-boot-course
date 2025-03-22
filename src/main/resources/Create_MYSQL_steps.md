1. docker pull library/mysql:latest
2. docker run --name=mysql_u -p 3305:3306 -e MYSQL_RANDOM_ROOT_PASSWORD=true -d library/mysql:latest
3. Enter GENERATED PASSWORD after get the logs from 'docker logs container_name'
4. docker exec -it <container_name> sh
5. mysql -u root -p
6. alter user 'root'@'localhost' identified by '123456';
7. FLUSH PRIVILEGES;
8. Restart container again and check the root user with new password from step 5
9. Create new user: CREATE USER 'jeremy'@'localhost' IDENTIFIED BY '123456';
10. Based on the scripts.sql follow steps below to generate data:
   1. CREATE DATABASE IF NOT EXISTS <db_name>; only for root user
   2. USE <db_name>; only for root user
11. Test connect with the new user and host with Spring setup: USER 'jeremy'@'localhost' IDENTIFIED BY '123456';




