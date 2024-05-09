package com.mruruc.daoFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionConfig {
    private   SqlSessionFactory sqlSessionFactory ;

    public SessionConfig()  {
        try(InputStream configFile = Resources.getResourceAsStream("mybatis-config.xml")){
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }

}
