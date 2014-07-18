package com.github.ogstation.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<T> extends SqlSessionDaoSupport
{

    public T search(String namespace, T t)
    {
        return getSqlSession().selectOne(namespace, t);
    }

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    protected <S> S getMapper(Class<S> clazz)
    {
        return getSqlSession().getMapper(clazz);
    }
}
