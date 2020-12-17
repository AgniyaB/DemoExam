package org.company.app.data.manager;

import org.company.app.data.GenderEnum;
import org.company.app.data.entity.ServiceEntity;
import org.company.app.data.entity.UserEntity;
import org.company.app.util.BaseManager;
import org.company.app.util.MysqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceEntityManager extends BaseManager
{
    public ServiceEntityManager(MysqlDatabase database)
    {
        super(database);
    }

    public void add(ServiceEntity service) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "INSERT INTO Service(Title, Cost, DurationInSeconds, Description, Discount, MainImagePath) values(?,?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, service.getTitle());
            s.setDouble(2, service.getCost());
            s.setInt(3, service.getDuration());
            s.setString(4,service.getDescription());
            s.setDouble(5, service.getDiscount());
            s.setString(6, service.getImpPath());
            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if(keys.next()) {
                service.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("User not added");
        }
    }

    public ServiceEntity getById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM Service WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            ResultSet resultSet = s.executeQuery();
            if(resultSet.next()) {
                return new ServiceEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getDouble("Cost"),
                        resultSet.getInt("DurationInSeconds"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Discount"),
                        resultSet.getString("MainImagePath")
                );
            }

            return null;
        }
    }

    public List<ServiceEntity> getAll() throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "SELECT * FROM Service";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ServiceEntity> services = new ArrayList<>();
            while(resultSet.next()) {
                services.add(new ServiceEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getDouble("Cost"),
                        resultSet.getInt("DurationInSeconds"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Discount"),
                        resultSet.getString("MainImagePath")
                ));
            }
            return services;
        }
    }

    public int update(ServiceEntity service) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "UPDATE Service SET Title=?, Cost=?, DurationInSeconds=?, Description=?, Discount=?, MainImagePath=? WHERE ID=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, service.getTitle());
            s.setDouble(2, service.getCost());
            s.setInt(3, service.getDuration());
            s.setString(4, service.getDescription());
            s.setDouble(5, service.getDiscount());
            s.setString(6, service.getImpPath());
            s.setInt(7, service.getId());

            return s.executeUpdate();
        }
    }

    public int deleteById(int id) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE FROM Service WHERE ID=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1, id);

            return s.executeUpdate();
        }
    }

    public int delete(ServiceEntity service) throws SQLException
    {
        return deleteById(service.getId());
    }
}
