package nos2jdbc.tutorial.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
	ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        MyApp app = applicationContext.getBean(MyApp.class);
        Data data = applicationContext.getBean(Data.class);
        CubeDumper cd = applicationContext.getBean(CubeDumper.class);
        data.insert();
        app.dump();
        app.dumpSqlSelect();
        app.dumpRollup();
        cd.loadKeys();
        cd.dumCube();
        cd.dumpCubeWithJoin();
    }

}
