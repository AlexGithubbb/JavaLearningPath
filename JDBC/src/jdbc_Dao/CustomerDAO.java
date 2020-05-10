package jdbc_Dao;

import jdbc_Dao.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDAO {

    void insert(Connection connection, Customer customer);

    void deleteById(Connection connection, int id);

    void update(Connection connection, Customer customer);

    Customer getCustomerById(Connection connection,int id);

    List<Customer> getAll(Connection connection);

    Long getCount(Connection connection); // long type , possible to have mass data

    Date getMaxBirth(Connection connection);


}
