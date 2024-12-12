package config;

import components.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        User user = context.getBean(User.class);
        System.out.println("User name is: "+ user.getName());
        user.printHello();
    }
}
