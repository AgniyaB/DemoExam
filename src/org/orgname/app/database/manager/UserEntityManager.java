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
            String sql = "INSERT INTO users(login, PASSWORD) values(?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPassword());
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
                    result.getString("PASSWORD")
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
                        result.getString("PASSWORD")
                ));
            }

            return users;
        }
    }

    public int save(UserEntity user) throws SQLException
    {
        try (Connection c = database.getConnection())
        {
            String sql = "UPDATE users SET login=?, PASSWORD=? WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPassword());
            s.setInt(3, user.getId());

            return s.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException
    {
        try (Connection c = database.getConnection())
        {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            return s.executeUpdate();
        }
    }
}
