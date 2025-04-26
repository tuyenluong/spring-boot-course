# Importing Hashed Passwords into MySQL in Docker

## **Step 1: Run the Java code to Hash Passwords**

- Run a Java code that generates **hashed passwords using Bcrypt**.
  - With class "[BcryptPasswordGenerator.java](BcryptPasswordGenerator.java)"
- Save the output in a CSV file (e.g., `hashed_passwords.csv`).

## **Step 2: Access the MySQL Container and Check Secure File Privilege**

1. **SSH into the Docker container running MySQL**:

   ```sh
   docker exec -it mysqlUser bash
   ```

   *(Replace ********`mysql-container`******** with the actual name of your MySQL container. You can check it with ********`docker ps`********.)*

2. **Log in to MySQL inside the container**:

   ```sh
   mysql -u root -p
   ```

   *(Enter your MySQL root password when prompted.)*

3. **Check the value of \*\*\*\*\*\*\*\*\*\*\*\*****`secure_file_priv`**:

   ```sql
   SHOW VARIABLES LIKE 'secure_file_priv';
   ```

    - If it returns a path (e.g., `/var/lib/mysql-files/`), MySQL **only allows file loading from that directory**.
    - If the value is `NULL`, MySQL **does not allow** loading external files.

## **Step 3: Move the CSV File into MySQL’s Allowed Directory**

1. Exit MySQL (`exit`) and the container (`exit`).
2. **Copy the CSV file into MySQL's allowed directory**:
   ```sh
   docker cp C:/spring-boot-course/hashed_passwords.csv mysqlUser:/var/lib/mysql-files/
   ```
   *(If you're using Linux/macOS, replace ********`C:/spring-boot-course/hashed_passwords.csv`******** with your actual file path.)*

## **Step 4: Create the Database Table for Hashed Passwords**

1. **Log back into MySQL**:

   ```sh
   docker exec -it mysqlUser mysql -u root -p
   ```

2. **Create the table to store hashed passwords**:

   ```sql
   CREATE TABLE hashed_passwords (
       id INT AUTO_INCREMENT PRIMARY KEY,
       password_hash VARCHAR(255) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

## **Step 5: Load the CSV File into MySQL**

1. **Run the ****************`LOAD DATA INFILE`**************** command**:
   ```sql
   LOAD DATA INFILE '/var/lib/mysql-files/hashed_passwords.csv'
   INTO TABLE hashed_passwords
   FIELDS TERMINATED BY ','
   LINES TERMINATED BY '\n'
   IGNORE 1 LINES
   (password_hash);
   ```

## **Step 6: Verify the Data Import**

Run the following query to check if the data was successfully imported:

```sql
SELECT * FROM hashed_passwords LIMIT 10;
```

## **Step 7: Drop person table if exists user record**

```sql
TRUNCATE  TABLE person_courses;
SET foreign_key_checks = 0;
TRUNCATE  TABLE person;
SET foreign_key_checks = 1;

DROP TABLE person_courses;
DROP TABLE person;
```

## **Step 8: Load all records from hashed password table as your new users**

```sql
INSERT INTO person (name, email, mobile_number, pwd, role_id, address_id, created_at, created_by)
SELECT 
    CONCAT('User', hp.id) AS name,
    CONCAT('user', hp.id, '@example.com') AS email,
    LPAD(7000000000 + hp.id, 10, '0') AS mobile_number,
    hp.password_hash AS pwd,
    1 AS role_id,
    NULL AS address_id,
    hp.created_at AS created_at,
    'DBA' AS created_by
FROM hashed_passwords hp;
```
```sql
select * from person where role_id=1 limit 10;
```

## **Troubleshooting**

### 1. If You Get **`ERROR 1290 (HY000): The MySQL server is running with the --secure-file-priv option so it cannot execute this statement`**

- Ensure you placed the file in MySQL’s allowed directory (`/var/lib/mysql-files/`).
- Try using `LOAD DATA LOCAL INFILE` instead:
  ```sql
  LOAD DATA LOCAL INFILE '/var/lib/mysql-files/hashed_passwords.csv'
  INTO TABLE hashed_passwords
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n'
  IGNORE 1 LINES
  (password_hash);
  ```
  *(Make sure the MySQL client is started with ********`--local-infile=1`********.)*

### 2. If You Get **`ERROR 2 (HY000): File Not Found`**

- Double-check that the file exists in `/var/lib/mysql-files/` using:
  ```sh
  docker exec -it mysqlUser ls -l /var/lib/mysql-files/
  ```
- If not, repeat **Step 3** to copy the file again.

### 3. If You Get **`ERROR 1261 (01000): Row doesn't contain data for all columns`**

- Ensure your CSV **only has one column** (password hashes).
- Modify the `LOAD DATA` query to specify only the `password_hash` column (as shown in Step 5).

---

## **Conclusion**

By following these steps, you can securely import **hashed passwords** into MySQL running inside a **Docker container**. 🎯

