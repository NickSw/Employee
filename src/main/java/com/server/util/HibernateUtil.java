package com.server.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Вспомогательный класс для работы с hibernate
 *
 * Методы:
 * Извлечение всех строк из таблице(список сущностей)
 * Извлечение всех строк из таблицы(по запросу, список сущностей)
 * Извлечение строки из таблицы по id(сущности)
 * Создать запись в таблице(сущность)
 * Обновление строки в таблице(сущность)
 * Удаление строки в таблице(сущность)
 * Удаление строки в таблице по id(сущность)
 * Перемещение строки из одной таблицы в другую(сущность)
 */
@Repository
public class HibernateUtil {
	
	@Autowired
    private SessionFactory sessionFactory;

    /**
     * Извлечение всех строк из таблице(список сущностей)
     * @param entityClass
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> fetchAll(Class<T> entityClass) {
        return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();
    }

    /**
     * Извлечение строки из таблицы по id(сущности)
     * @param query
     * @param <T>
     * @return
     */
    @SuppressWarnings("rawtypes")
    public <T> List fetchAll(String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
    }

    /**
     * Извлечение строки из таблицы как сущности по id
     * @param id
     * @param entityClass
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T fetchById(Serializable id, Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }

    /**
     * Создать запись в таблице(сущность)
     * @param entity
     * @param <T>
     * @return
     */
    public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);        
    }

    /**
     * Обновление строки в таблице(сущность)
     * @param entity
     * @param <T>
     * @return
     */
    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);   
        return entity;
    }

    /**
     * Удаление строки в таблице(сущность)
     * @param entity
     * @param <T>
     */
	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

    /**
     * Удаление строки в таблице по id(сущность)
     * @param id
     * @param entityClass
     * @param <T>
     */
	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

    /**
     * Перемещение строки из одной таблицы в другую(сущность)
     * @param query
     * @param entity
     * @param <T>
     * @return
     */
    public <T> int move(String query, final T entity) {
         int result = sessionFactory.getCurrentSession().createSQLQuery(query).executeUpdate();
         sessionFactory.getCurrentSession().delete(entity);
         return result;
    }

}
