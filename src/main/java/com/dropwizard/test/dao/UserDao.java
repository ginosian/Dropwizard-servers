package com.dropwizard.test.dao;

import com.dropwizard.test.core.entity.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {

    @SqlQuery("select id, name from user where id = :id")
    User get(@Bind("id") long id);

    @SqlQuery("select * from user")
    List<User> getAll();

    @SqlUpdate("insert into user (id, name) values (:id, :name)")
    void insert(@Bind("id") long id, @Bind("name") String name);

    @SqlUpdate("update user set (id, name) values (:id, :name)")
    void update(@Bind("id") long id, @Bind("name") String name);

    @SqlUpdate("update user set (deleted) values (:deleted) where id = :id")
    void delete(@Bind("id") long id, @Bind("deleted") boolean deleted);
}
