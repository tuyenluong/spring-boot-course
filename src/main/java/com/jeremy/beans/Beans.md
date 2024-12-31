## Explanation

In the Spring Framework, beans are objects that are managed by the Spring IoC (Inversion of Control) container. These beans form the backbone of a Spring application, providing the required objects, their configurations, dependencies, and lifecycle management.

## What is a Bean?
A bean is an instance of a class that is initialized, assembled, and managed by the Spring container.
Beans are created based on configurations defined in:
XML configuration files.
Java-based configuration using `@Configuration` and `@Bean`.
Component scanning with annotations like `@Component`, `@Service`, `@Repository`, `@Controller`

## How Beans Are Defined
1. Using `@Component` and Stereotype Annotations
- The class is marked with an annotation like `@Component`, `@Service`, or `@Repository`.
- Spring's component scanning automatically registers these classes as beans.
- Example:
```java
@Component
public class MyService {
    public String serve() {
        return "Service is running!";
    }
}
```
2. Using @Bean Annotation
- Beans are explicitly defined in a configuration class.
- Example:
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```
3. Using XML Configuration (Legacy Approach)
- Beans are defined in an XML file.
- Example:
```xml
<bean id="myService" class="com.example.MyService"/>
```

## Bean Scopes
The scope determines how and when a bean instance is created.

| **Scope**       | **Description**                                                                                      |
|------------------|----------------------------------------------------------------------------------------------------|
| `singleton`      | A single instance of the bean is created and shared across the application context. (Default)       |
| `prototype`      | A new instance is created each time the bean is requested.                                          |
| `request`        | A single instance is created per HTTP request (web applications only).                              |
| `session`        | A single instance is created per HTTP session (web applications only).                              |
| `application`    | A single instance is created per ServletContext (web applications only).                            |
| `websocket`      | A single instance is created per WebSocket lifecycle (web applications only).                       |

## Bean Lifecycle
1. Initialization:
   2. Spring creates and initializes the bean. 
   3. If a bean has dependencies, they are injected during initialization.
2. Custom Initialization and Destruction:
   3. Implement custom behavior using:
      4. @PostConstruct: Runs after the bean is initialized. 
      5. @PreDestroy: Runs before the bean is destroyed. 
   4. Example:
```java
@Component
public class MyService {
    @PostConstruct
    public void init() {
        System.out.println("Initialization logic...");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Cleanup logic...");
    }
}
```
3. Lifecycle Callbacks:
   4. You can implement the InitializingBean and DisposableBean interfaces for more granular control. 
   5. Example:
```java
public class MyService implements InitializingBean, DisposableBean {
    public void afterPropertiesSet() {
        System.out.println("Initialization logic...");
    }

    public void destroy() {
        System.out.println("Cleanup logic...");
    }
}
```
## Dependency Injection (DI)
Beans often rely on other beans. Spring provides multiple ways to inject these dependencies:

- Constructor Injection:
```java
@Component
public class MyService {
    private final Dependency dependency;

    public MyService(Dependency dependency) {
        this.dependency = dependency;
    }
}
```
- Setter Injection:
```java
@Component
public class MyService {
    private Dependency dependency;

    @Autowired
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
```
- Field Injection:
```java
@Component
public class MyService {
    @Autowired
    private Dependency dependency;
}
```

## Annotations for Bean Management
| Annotation      | Purpose                                                                            |
|-----------------|------------------------------------------------------------------------------------|
| `@Component`    | Marks a class as a Spring-managed component.                                       |
| `@Service`      | A specialization of `@Component` for service layer components.                     |
| `@Repository`   | A specialization of `@Component` for persistence layer components.                |
| `@Controller`   | A specialization of `@Component` for presentation layer components.               |
| `@Bean`         | Defines a bean explicitly in a configuration class.                               |
| `@Scope`        | Specifies the scope of the bean (e.g., singleton, prototype).                      |
| `@Primary`      | Marks a bean as the primary candidate when multiple beans are available.          |
| `@Qualifier`    | Used to disambiguate when multiple beans of the same type exist.                   |

## Conclusion
Beans in Spring form the foundation for building a loosely coupled and highly modular application. By managing the lifecycle, dependency injection, and scopes of beans, Spring provides a robust framework for enterprise-grade applications. Let me know if you need clarification on any specific part!