package jdbc.exer;

import jdbc.bean.Student;
import jdbc.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class SelectStudentTest {

    /* Query with either IDCard or ExamCard*/
    public static void main(String[] args) {
        System.out.println("请选择您要输入的类型： \na:准考证号\nb：身份证号");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();

        Student student = new Student();
        if(type.equalsIgnoreCase("a")) {
            System.out.println("请输入准考证号进行查询");
            String ExamCard = scanner.next();
            String sql = "select FlowID, Type type, IDCard, ExamCard, StudentName, Location, Grade from examstudent where ExamCard = ?";
            student = getInstance(Student.class, sql, ExamCard);

        }else if(type.equalsIgnoreCase("b")){
            System.out.println("请输入身份证号进行查询");
            String IDcard = scanner.next();
            String sql = "select FlowId, Type, IDCard, ExamCard, StudentName, Location, Grade from examstudent where IDcard = ?";
            student = getInstance(Student.class, sql, IDcard);
        }

        if(student != null){
            System.out.println(student);
        }else{
            System.out.println("查无此人，请重新输入");
        }
    }



    /* 针对不同表的通用查询操作， 返回表中的一条记录*/
    public static  <T> T getInstance(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            // 处理占位符 '？'
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();


            if(resultSet.next()){
                T t = clazz.newInstance();
                // handle each col of each row of resultSet
                for (int i = 0; i < columnCount; i++) {
                    // Retrieves the value of the designated column in the current row of this ResultSet object
                    Object columnValue = resultSet.getObject(i + 1);

                    // insert the value into Customer by using reflection
                    String columnLabel = metaData.getColumnLabel(i+1);
                    /* 给 t 对象指定的属性赋值 columnValue， 使用reflection*/
                    Field field = clazz.getDeclaredField(columnLabel); // get the field name which is as same as columnLabel;
                    field.setAccessible(true); // 可以访问私有化属性
                    field.set(t, columnValue); // set columnValue to the field
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }
}
