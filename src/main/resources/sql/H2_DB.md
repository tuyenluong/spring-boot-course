As of SpringBoot 3.2.1 in order to specify the schema.sql file and data.sql file you can use following configurations in application.properties.

```properties
spring.sql.init.schema-locations=classpath:sql/schema.sql
spring.sql.init.data-locations=classpath:sql/data.sql
```

As of above configuration, sql files need to be specified inside resources/sql directory. Note that sql directory is created manually inside the resources folder.

enter image description here

To control the initialization of the database spring.sql.init.mode configuration could be used.

Following is a sample application.properties file.
```properties
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:sql/schema.sql
spring.sql.init.data-locations=classpath:sql/data.sql
spring.jpa.hibernate.ddl-auto=none
```
More details on above configurations could be found [here](https://docs.spring.io/spring-boot/how-to/data-initialization.html#howto.data-initialization.using-basic-sql-scripts)

[References](https://stackoverflow.com/questions/67805354/error-with-h2-not-creating-the-schema-with-my-data-sql-file)