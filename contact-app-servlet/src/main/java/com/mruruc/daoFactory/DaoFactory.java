package com.mruruc.daoFactory;

import com.mruruc.repository.ContactRepository;
import com.mruruc.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;

public class DaoFactory {
    private static final SessionConfig sessionConfig = new SessionConfig();

    private DaoFactory() {}

    public static UserRepository getUserDao()  {
        SqlSession sqlSession = sessionConfig.getSession();
        return sqlSession.getMapper(UserRepository.class);
    }

    public static ContactRepository getContactDao() {
        SqlSession sqlSession = sessionConfig.getSession();
        return sqlSession.getMapper(ContactRepository.class);
    }



}
