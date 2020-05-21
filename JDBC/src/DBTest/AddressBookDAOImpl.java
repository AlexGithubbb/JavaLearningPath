package DBTest;

import DBTest.bean.Address;

import java.sql.Connection;
import java.util.List;

public class AddressBookDAOImpl extends BaseDAO<Address> implements AddressBookDAO {

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from address where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void deleteByName(Connection conn, String name) {
        String sql = "delete from address where Name = ?";
        update(conn, sql, name);
    }

    @Override
    public void insert(Connection conn, Address address) {
        String sql = "insert into address (id, Name, Street, Province, Country_id, ZipCode) values(?, ?, ?, ?, ?, ?)";
        update(conn, sql, address.getId(),  address.getName(), address.getStreet(), address.getProv(), address.getCountry_id(), address.getZipcode());
    }

    @Override
    public void update(Connection conn, Address address) {
        String sql = "update address set Name= ?, Street=?, Province=?, Country_id = ?, ZipCode = ? where id = ?";
        update(conn, sql,  address.getName(), address.getStreet(), address.getProv(), address.getCountry_id(), address.getZipcode(), address.getId());
    }

    @Override
    public Address selectOne(Connection conn, int id) {
        String sql = "select  Street street, Province prov,Country_id country_id, ZipCode from address where id = ?";
        Address address = selectInstance(conn, sql, id);
        return address;
    }

    @Override
    public List selectAll(Connection conn) {
        String sql = "select id, Name name , Street street, Province prov,Country_id country_id, ZipCode from address";
        List<Address> list = selectForList(conn, sql);
        return list;
    }
}
