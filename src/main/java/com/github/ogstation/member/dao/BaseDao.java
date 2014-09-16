package com.github.ogstation.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseDao<T> extends SqlSessionDaoSupport
{

    public T get(String namespace, String key)
    {
        return getSqlSession().selectOne(namespace, key);
    }

    public List<T> get(String namespace, Pageable pageable)
    {
        return getSqlSession().selectList(namespace, pageable);
    }

    public T search(String namespace, T t)
    {
        return getSqlSession().selectOne(namespace, t);
    }

    public int create(String namespace, T t)
    {
        return getSqlSession().insert(namespace, t);
    }

    public int update(String namespace, T t)
    {
        return getSqlSession().update(namespace, t);
    }

    public int delete(String namespace, String key)
    {
        return getSqlSession().delete(namespace, key);
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
