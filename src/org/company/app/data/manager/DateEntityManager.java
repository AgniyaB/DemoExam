package org.company.app.data.manager;

import org.company.app.data.GenderEnum;
import org.company.app.data.entity.DateEntity;
import org.company.app.data.entity.UserEntity;
import org.company.app.util.MysqlDatabase;

import java.sql.*;

public class DateEntityManager
{
    private final MysqlDatabase database;

    public DateEntityManager(MysqlDatabase database) {
        this.database = database;
    }

    public void add(DateEntity entity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO date_entities(date_value) values(?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setTimestamp(1, new Timestamp(entity.getDate().getTime()));
            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if(keys.next()) {
                entity.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("User not added");
        }
    }

    public DateEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM date_entities WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new DateEntity(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date_value") //так как Timestamp наследует Date ничего делать не надо
                );
            }

            return null;
        }
    }
}
