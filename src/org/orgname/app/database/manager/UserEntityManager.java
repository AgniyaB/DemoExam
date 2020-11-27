package org.orgname.app.database.manager;

import org.orgname.app.database.entity.GenderEnum;
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

    public void add(UserEntity userEntity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO users_full (login, password, gender, age, job, notes) values (?,?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, userEntity.getLogin());
            s.setString(2, userEntity.getPassword());
            s.setString(3, userEntity.getGender().name());
            s.setInt(4, userEntity.getAge());
            s.setString(5, userEntity.getJob());
            s.setString(6, userEntity.getNotes());
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
            String sql = "SELECT * FROM users_full WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        GenderEnum.valueOf(resultSet.getString("gender")),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("notes")
                );
            }

            return null;
        }
    }

    public UserEntity getByLoginAndPassword(String login, String pass) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users_full WHERE login=? AND PASSWORD=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, login);
            s.setString(2, pass);

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        GenderEnum.valueOf(resultSet.getString("gender")),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("notes")
                );
            }

            return null;
        }
    }


    public List<UserEntity> getAll() throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM users_full";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<UserEntity> users = new ArrayList<>();
            while(resultSet.next()) {
                users.add(new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        GenderEnum.valueOf(resultSet.getString("gender")),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("notes")
                ));
            }

            return users;
        }
    }

    public int update(UserEntity userEntity) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE users_full SET login=?, password=?, gender=?, age=?, job=?, notes=? WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, userEntity.getLogin());
            s.setString(2, userEntity.getPassword());
            s.setString(3, userEntity.getGender().name());
            s.setInt(4, userEntity.getAge());
            s.setString(5, userEntity.getJob());
            s.setString(6, userEntity.getNotes());
            s.setInt(7, userEntity.getId());

            return s.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM users_full WHERE id=?";
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
