package ru.pa4ok.appname.database.manager;

import ru.pa4ok.appname.database.entity.UserEntity;
import ru.pa4ok.appname.util.BaseManager;
import ru.pa4ok.appname.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEntityManager extends BaseManager
{
    public UserEntityManager(MysqlDatabase database) {
        super(database);
    }

    /*
        после того как вы написали sql строку с запросом
        вам нужно создать объект "предзапроса"
        Statement s;
        PreparedStatement ps;
        у второго есть возможно заменять ? из sql строки

        Statement s = c.createStatement();
        PreparedStatement ps = c.prepareStatement(sql);

         ps.executeUpdate(); используется когда нам не нужно ничего возращать (все кроме Select)
         ps.executeQuery(); используется при Select
     */

    public void add(UserEntity user) throws SQLException
    {
        try(Connection c = database.getConnection()) //по выходу из блока try connection закротся автоматически
        {
            String sql = "INSERT INTO users_small(login, password, age, job) values(?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getJob());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                user.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("User not added, no generated key");
        }
    }

    public UserEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users_small WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            if(result.next()) {
                return new UserEntity(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getInt("age"),
                        result.getString("job")
                );
            }
            return null;
        }
    }

    public List<UserEntity> getAll() throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users_small";
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);

            List<UserEntity> users = new ArrayList<>();
            while(result.next()) {
                users.add(new UserEntity(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getInt("age"),
                        result.getString("job")
                ));
            }
            return users;
        }
    }

    public void update(UserEntity user) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE users_small SET login=?, password=?, age=?, job=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getJob());
            ps.setInt(5, user.getId());

            ps.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM users_small WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

    public void delete(UserEntity user) throws SQLException
    {
        deleteById(user.getId());
    }
}
