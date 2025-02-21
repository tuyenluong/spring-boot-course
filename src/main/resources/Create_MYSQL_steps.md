1. docker pull library/mysql:latest
2. docker run --name=mysql_u -p 3305:3306 -e MYSQL_RANDOM_ROOT_PASSWORD=true -d library/mysql:latest
3. mysql -u root -p
4. Enter GENERATED PASSWORD after get the logs from 'docker logs container_name'
5. alter user 'root'@'localhost' identified by '123456';
6. FLUSH PRIVILEGES;
7. Restart container again and check the root user with new password from step 5
8. Create new user: CREATE USER 'jeremy'@'172.17.0.1' IDENTIFIED BY '123456';
9. Connect with the new user and host.




