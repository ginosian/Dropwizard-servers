package com.dropwizard.test.dao.mapper;

        import com.dropwizard.test.core.entity.User;
        import org.jdbi.v3.core.mapper.RowMapper;
        import org.jdbi.v3.core.statement.StatementContext;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class UserMapper {

    private static final String ID = "id";
    private static final String NAME = "name";

    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        RowMapper rowMapper = statementContext.findMapperFor(User.class).orElse(null);

        if (rowMapper == null) {
            // throw something here
        }
        rowMapper.map(resultSet, statementContext);
        return new User(resultSet.getString(ID), resultSet.getString(NAME));
    }
}
