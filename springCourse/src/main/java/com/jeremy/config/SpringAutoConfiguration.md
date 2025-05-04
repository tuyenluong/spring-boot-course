## What Spring Auto-Configuration does?
Spring Auto-Configuration logs provide details about the beans and configurations that are automatically created and managed by Spring Boot based on the classpath, environment settings, and annotations. These logs help developers debug, optimize, or understand Spring Boot's automatic configuration process.

Here’s what you typically find in the Spring Auto-Configuration logs:

### Condition Evaluation
- Condition evaluation report shows which configurations and beans have been included or excluded.
- Logs are typically structured into positive matches (enabled configurations) and negative matches (disabled or excluded configurations).
```java
Positive matches:
   - DataSourceAutoConfiguration matched (OnClassCondition)
   - JpaRepositoriesAutoConfiguration matched (OnBeanCondition)

Negative matches:
   - RabbitAutoConfiguration did not match (OnClassCondition)
   - MongoAutoConfiguration did not match (OnPropertyCondition)
```
- This section helps identify why certain beans or configurations were included or skipped.

### Enabled Auto-Configurations
- Lists all the auto-configuration classes that have been applied.
```java
@ConditionalOnClass: found DataSource, JdbcTemplate
@ConditionalOnMissingBean: no DataSource bean found
```
These annotations show the conditions under which certain configurations are applied.

### Bean Definitions
- Logs show which beans were created and their source (e.g., auto-configuration, custom configuration, etc.).
```java
Bean 'dataSource' of type 'HikariDataSource' created via DataSourceAutoConfiguration
Bean 'entityManagerFactory' of type 'EntityManagerFactory' created via HibernateJpaAutoConfiguration
```

### Property Resolutions
- Shows property values resolved from application.properties or application.yml.
```java
Property source 'applicationConfig: [classpath:/application.properties]' resolved:
   dataSource.url=jdbc:mysql://localhost:3306/testdb
   dataSource.username=root
```

### Debugging Conditional Annotations
- Logs details of @ConditionalOnClass, @ConditionalOnBean, @ConditionalOnProperty, and other @Conditional annotations.
```java
DataSourceAutoConfiguration:
   - @ConditionalOnClass found required classes
   - @ConditionalOnProperty "spring.datasource.url" matched
```

### Failed Auto-Configurations
- Shows configurations that were not applied, along with the reason for failure.
```java
HibernateJpaAutoConfiguration did not match:
   - @ConditionalOnClass classes not found: org.hibernate.Session (OnClassCondition)
```

### Dependency Injection Debugging
- Shows information about bean injection, including conflicts or circular dependencies.
```text
Error creating bean with name 'userService':
   Unsatisfied dependency expressed through field 'userRepository';
   nested exception is NoSuchBeanDefinitionException: No qualifying bean of type 'UserRepository' available
```

### Additional Diagnostic Information
- Logs additional details when debug mode is enabled (debug=true in application.properties).
- Provides information on the initialization of beans, such as:
  - Constructor calls.
  - Dependency injection lifecycle.
  - Post-processors applied to beans.

## How to Enable Auto-Configuration Logs in Spring Boot
To enable these logs:
1. Add the following to application.properties:
```text
debug=true
```

## Why Is This Useful?
- Debugging: Understand why specific configurations or beans are included or excluded.
- Optimization: Identify unused auto-configurations to exclude and improve application startup time.
- Customization: Override auto-configured beans or fine-tune configurations.


