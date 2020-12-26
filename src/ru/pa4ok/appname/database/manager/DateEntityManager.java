package ru.pa4ok.appname.database.manager;

import ru.pa4ok.appname.database.entity.DateEntity;
import ru.pa4ok.appname.util.BaseManager;
import ru.pa4ok.appname.util.MysqlDatabase;

import java.sql.*;

public class DateEntityManager extends BaseManager
{
    public DateEntityManager(MysqlDatabase database) {
        super(database);
    }

    public void add(DateEntity dateEntity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO date_entities(date_value) values(?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, new Timestamp(dateEntity.getDate().getTime()));

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                dateEntity.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("User not added, no generated key");
        }
    }

    public DateEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM date_entities WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            if(result.next()) {
                return new DateEntity(
                        result.getInt("id"),
                        //так как Timestamp наследует Date
                        //происходит неявное приведение типов
                        //и ничего делать не надо
                        result.getTimestamp("date_value")
                );
            }
            return null;
        }
    }
}
