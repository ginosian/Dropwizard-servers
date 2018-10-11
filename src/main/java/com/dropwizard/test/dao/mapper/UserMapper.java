package com.dropwizard.test.dao.mapper;

        import com.dropwizard.test.core.entity.User;
        import org.jdbi.v3.core.mapper.RowMapper;
        import org.jdbi.v3.core.statement.StatementContext;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class UserMapper {

    private static final String ID = "id";
    private static final String DELETED = "deleted";
    private static final String NAME = "name";

    public User map(final ResultSet resultSet, final StatementContext statementContext) throws SQLException {
        final RowMapper rowMapper = statementContext.findMapperFor(User.class).orElse(null);
        if (rowMapper == null) {
            // throw something here
        }
        rowMapper.map(resultSet, statementContext);
        return new User(resultSet.getLong(ID), resultSet.getBoolean(DELETED), resultSet.getString(NAME));
    }
}
