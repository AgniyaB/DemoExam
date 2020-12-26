package ru.pa4ok.appname.database.manager;

import ru.pa4ok.appname.database.entity.FilmEntity;
import ru.pa4ok.appname.util.BaseManager;
import ru.pa4ok.appname.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmEntityManager extends BaseManager
{
    public FilmEntityManager(MysqlDatabase database) {
        super(database);
    }

    public void add(FilmEntity film) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO films(title, author, budget, duration) values(?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getAuthor());
            ps.setInt(3, film.getBudget());
            ps.setDouble(4, film.getDuration());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                film.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("Client not added, no generated key");
        }
    }

    public FilmEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM films WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            if(result.next()) {
                return new FilmEntity(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getInt("budget"),
                        result.getDouble("duration")
                );
            }
            return null;
        }
    }

    public List<FilmEntity> getAll() throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM films";
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);

            List<FilmEntity> films = new ArrayList<>();
            while(result.next()) {
                films.add(new FilmEntity(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getInt("budget"),
                        result.getDouble("duration")
                ));
            }
            return films;
        }
    }

    public void update(FilmEntity film) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE films SET title=?, author=?, budget=?, duration=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getAuthor());
            ps.setInt(3, film.getBudget());
            ps.setDouble(4, film.getDuration());
            ps.setInt(5, film.getId());

            ps.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM films WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

    public void delete(FilmEntity film) throws SQLException
    {
        deleteById(film.getId());
    }
}
