package DBTest.junit;

import DBTest.AddressBookDAOImpl;
import DBTest.GetConnection;
import DBTest.bean.Address;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;


public class AddressBookImplTest  {

    AddressBookDAOImpl dao = new AddressBookDAOImpl();

    @Test
    public void insertTest() throws Exception {
        Connection conn = GetConnection.getConnection();
        Address address = new Address(6, "pop", "123 street", "CO", 1, "12B 12B");
        dao.insert(conn, address);
    }

    @Test
    public void deleteByIdTest() throws Exception {
        Connection conn = GetConnection.getConnection();
        dao.deleteById(conn, 6);
    }

    @Test
    public void deleteByName() throws Exception {
        Connection conn = GetConnection.getConnection();
        dao.deleteByName(conn, "pop");
    }
    @Test
    public void updateTest() throws Exception {
        Connection conn = GetConnection.getConnection();
        Address address = new Address(0,"Sally", "123 Tompson street", "OK", 33, "OP0 12N");
        dao.update(conn, address);
    }

    @Test
    public void querySingle() throws Exception {
        Connection conn = GetConnection.getConnection();
        Address address = dao.selectOne(conn, 2);
        System.out.println(address);
    }

    @Test
    public void queryForAll() throws Exception {
        Connection conn = GetConnection.getConnection();
        List list = dao.selectAll(conn);
        list.forEach(System.out::println);
    }




}
