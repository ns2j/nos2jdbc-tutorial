package nos2jdbc.tutorial.kotlinspring;


import javax.sql.DataSource

import org.seasar.extension.dataset.DataSet
import org.seasar.extension.dataset.impl.SqlWriter
import org.seasar.extension.dataset.impl.SsReader
import org.seasar.extension.jdbc.manager.JdbcManagerImplementor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import nos2jdbc.tutorial.kotlinspring.service.ClubService

@Component
public class Data(var clubService: ClubService) {
    //@Autowired
    //lateinit var jdbcManager: JdbcManagerImplementor;

    //@Autowired
    //lateinit var clubService: ClubService;

    @Transactional
    fun insert() {
        if (clubService.findAll().size > 0) return;
        val implementor = clubService.jdbcManager as JdbcManagerImplementor
        val dataSet:DataSet = SsReader("init.xlsx", true).read();

        val dataSource: DataSource = implementor.getDataSource();
        SqlWriter(dataSource).write(dataSet);
    }
}
