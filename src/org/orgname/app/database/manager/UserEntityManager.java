package org.orgname.app.database.manager;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEntityManager
{
    private MysqlDatabase database;

    public UserEntityManager(MysqlDatabase database) {
        this.database = database;
    }

    public void add(UserEntity user) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO users(login, password, age, job) values(?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPass());
            s.setInt(3, user.getAge());
            s.setString(4, user.getJob() == null ? "" : user.getJob());
            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if(keys.next()) {
                user.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("User not added");
        }
    }

    public UserEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            ResultSet result = s.executeQuery();
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

    public UserEntity getByLoginAndPassword(String login, String password) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users WHERE login=? AND password=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, login);
            s.setString(2, password);

            ResultSet result = s.executeQuery();
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
            String sql = "SELECT * FROM users";
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

    public int update(UserEntity user) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE users SET login=?, password=?, age=?, job=? WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPass());
            s.setInt(3, user.getAge());
            s.setString(4, user.getJob() == null ? "" : user.getJob());
            s.setInt(5, user.getId());

            return s.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            return s.executeUpdate();
        }
    }
}
