package nos2jdbc.tutorial.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (GenericApplicationContext applicationContext = 
                new AnnotationConfigApplicationContext(AppConfig.class)) {
            MyApp app = applicationContext.getBean(MyApp.class);
            app.dump();
            app.insertData();
            app.dump();
        }
    }

}