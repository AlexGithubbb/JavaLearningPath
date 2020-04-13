package exer1;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("001", new User(001, 12,"Alex"));
        dao.save("002", new User(002, 14,"Bob"));
        dao.save("003", new User(003, 11,"Jay"));


        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);

        dao.update("003", new User(003, 12, "jam"));
        list = dao.list();
        list.forEach(System.out::println);
    }
}
