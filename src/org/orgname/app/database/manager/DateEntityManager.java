package org.orgname.app.database.manager;

import org.orgname.app.database.entity.DateEntity;
import org.orgname.app.util.MysqlDatabase;

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

            throw new SQLException("Date entity not added");
        }
    }

    public DateEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM date_entities WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            ResultSet result = s.executeQuery();
            if(result.next()) {
                return new DateEntity(
                        result.getInt("id"),
                        //нам нужнен Date, но так как TimeStamp наследует его
                        //то можно оставить так, произойдет неявное приведение типов
                        result.getTimestamp("date_value")
                );
            }

            return null;
        }
    }
}
