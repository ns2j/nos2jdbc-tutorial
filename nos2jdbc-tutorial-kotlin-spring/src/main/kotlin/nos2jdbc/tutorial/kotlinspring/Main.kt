package nos2jdbc.tutorial.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
class Main

fun main(args: Array<String>) {
   runApplication<Main>(*args).apply({
        val app = getBean(MyApp::class.java)
	val data = getBean(Data::class.java)
	val cd = getBean(CubeDumper::class.java)
	data.insert()
	app.dump()
        app.dumpSqlSelect()
        app.dumpRollup()
        cd.loadKeys()
        cd.dumpCube()
        cd.dumpCubeWithJoin()
    }); 

	/*
       val appContext: ApplicationContext = SpringApplication.run(Main::class.java, *args)
     val app = appContext.getBean(MyApp::class.java)
	app.dump()
	app.insertData()
	app.dump()
*/	
}