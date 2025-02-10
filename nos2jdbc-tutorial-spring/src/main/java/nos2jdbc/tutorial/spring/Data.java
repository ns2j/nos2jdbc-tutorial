package nos2jdbc.tutorial.spring;


import javax.sql.DataSource;

import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.impl.SqlWriter;
import org.seasar.extension.dataset.impl.SsReader;
import org.seasar.extension.jdbc.manager.JdbcManagerImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nos2jdbc.tutorial.spring.entity.Club;
import nos2jdbc.tutorial.spring.service.ClubService;

@Component
public class Data {
    @Autowired
    JdbcManagerImplementor jdbcManager;

    @Autowired
    ClubService clubService;

    @Transactional
    public void insert() {
        if (clubService.findAll().size() > 0) return;
        
        DataSet dataSet = new SsReader("init.xlsx", true).read();

        DataSource dataSource = jdbcManager.getDataSource();
        new SqlWriter(dataSource).write(dataSet);

        upsert();
    }
    @Transactional
    public void upsert() {
        Club c = clubService.findById(1L);
        c.name = "硬式野球部";
        clubService.upsert(c);
        c.id = null;
        c.name = "美術部";
        clubService.upsert(c);
    }
}
