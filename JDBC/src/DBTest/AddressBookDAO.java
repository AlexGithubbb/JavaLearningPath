package DBTest;

import DBTest.bean.Address;

import java.sql.Connection;
import java.util.List;

public interface AddressBookDAO {

    // delete by id
    void deleteById(Connection conn, int id);

    // delete by name
    void deleteByName(Connection conn, String name);

    // insert
    void insert(Connection conn, Address address);

    // udpate
    void update(Connection conn, Address address);

    // select one address by id
    Address selectOne(Connection conn, int id);

    // select all addresses
    List selectAll(Connection conn);

}
