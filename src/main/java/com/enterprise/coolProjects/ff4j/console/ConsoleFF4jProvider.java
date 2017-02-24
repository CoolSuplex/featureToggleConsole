package com.enterprise.coolProjects.ff4j.console;

import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.dbcp.BasicDataSource;
import org.ff4j.FF4j;
import org.ff4j.store.*;
import org.ff4j.web.FF4JProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


@Component
public class ConsoleFF4jProvider implements FF4JProvider{

    @Autowired
    private FF4j ff4j;

    public ConsoleFF4jProvider() {
    }
    
    public DataSource getMySqlDatasource() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        try {
            Base64 base64 = new Base64();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");           
            dataSource.setUrl("jdbc:mysql://featuretoggle-poc.cvg63gqqyfjt.us-east-1.rds.amazonaws.com:3306/FT_POC");
            dataSource.setUsername("ashutosh");
            dataSource.setPassword("ashutosh");
        }
        catch (final Exception ex) {
            System.out.println(ex);
        }
    return dataSource;
}
    

    @Override
    public FF4j getFF4j() {

    	JdbcFeatureStore jdbcFeatureStore = new JdbcFeatureStore();
        try {
			jdbcFeatureStore.setDataSource(getMySqlDatasource());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(FF4j.class); 
        context.refresh();

        FF4j ff4j= context.getBean(FF4j.class);
        ff4j.setFeatureStore(jdbcFeatureStore);
        return ff4j;
    	
    }
}
