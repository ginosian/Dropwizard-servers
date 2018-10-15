package org.dropwizard.test.dao;

import org.dropwizard.test.core.entity.User;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends SqlObject {

    @RegisterBeanMapper(User.class)
    default User get(long id){
        return getHandle()
                .createQuery("select id, name from user where id = :id")
                .bind("id", id)
                .mapToBean(User.class).findOnly();
    }

    @RegisterBeanMapper(User.class)
    default Optional<User> find(long id){
        return getHandle()
                .createQuery("select id, name from user where id = :id")
                .bind("id", id)
                .mapToBean(User.class).findFirst();
    }

    @RegisterBeanMapper(User.class)
    default List<User> list()  {
        return getHandle().createQuery("SELECT * FROM users")
                .mapToBean(User.class)
                .list();
    }

    @RegisterBeanMapper(User.class)
    default List<User> getAll(){
        return getHandle().createQuery("SELECT * FROM user")
                .mapToBean(User.class)
                .list();
    }

    @RegisterBeanMapper(User.class)
    default User insert(long id, String name){
        return getHandle()
                .createQuery("insert into user (id, name) values (:id, :name)")
                .bind("id", id)
                .bind("name", name)
                .mapToBean(User.class).findOnly();
    }

    @RegisterBeanMapper(User.class)
    default User update(long id, String name){
        return getHandle()
                .createQuery("update user set (id, name) values (:id, :name)")
                .bind("id", id)
                .bind("name", name)
                .mapToBean(User.class).findOnly();
    }

    @SqlUpdate("update user set (deleted) values (:deleted) where id = :id")
    void delete(@Bind("id") long id, @Bind("deleted") boolean deleted);
}
