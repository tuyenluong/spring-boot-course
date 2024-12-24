import beans.User;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before retrieving the Jeremy bean from the Spring context");
        User user = context.getBean(User.class);
        System.out.println("After retrieving the Jeremy bean from the Spring context");
    }
}
