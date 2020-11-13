package ru.pa4ok.demoexam.database.manager;

import ru.pa4ok.demoexam.database.entity.UserEntity;
import ru.pa4ok.demoexam.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEntityManager
{
    private MysqlDatabase database;

    public UserEntityManager(MysqlDatabase database) {
        this.database = database;
    }

    public void add(UserEntity userEntity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO users (login, password, age, job) values (?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, userEntity.getLogin());
            s.setString(2, userEntity.getPassword());
            s.setInt(3, userEntity.getAge());
            s.setString(4, userEntity.getJob());
            s.executeUpdate();

            ResultSet resultSet = s.getGeneratedKeys();
            if (resultSet.next()) {
                userEntity.setId(resultSet.getInt(1));
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

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getInt("age"),
                        resultSet.getString("job")
                );
            }

            return null;
        }
    }

    public UserEntity getByAuth(String login, String pass) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users WHERE login=? AND PASSWORD=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, login);
            s.setString(2, pass);

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getInt("age"),
                        resultSet.getString("job")
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
            ResultSet resultSet = s.executeQuery(sql);

            List<UserEntity> users = new ArrayList<>();
            while(resultSet.next()) {
                users.add(new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getInt("age"),
                        resultSet.getString("job")
                ));
            }

            return users;
        }
    }

    public int update(UserEntity userEntity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE users SET login=?, PASSWORD=?, age=?, job=? WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, userEntity.getLogin());
            s.setString(2, userEntity.getPassword());
            s.setInt(3, userEntity.getAge());
            s.setString(4, userEntity.getJob());
            s.setInt(5, userEntity.getId());

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

    public int delete(UserEntity user) throws SQLException
    {
        return deleteById(user.getId());
    }
}
