package jdbc.exer;

import jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudentTest {
    public static void main(String[] args) {
        System.out.println("请输入要删除学生的考号");
        Scanner scanner = new Scanner(System.in);
        String ExamCard = scanner.next();
        String sql = "delete from examstudent where ExamCard = ?";
        int update = update(sql, ExamCard);

        if(update > 0){
            System.out.println("delete sucessfully!");
        }else{
            System.out.println("delete operation failed...");
        }
    }

    public static int update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            // 处理占位符 '？'
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            // return true if there is a resultSet, means we are doing select command
            // false if update(insert, delete, update)
            /*ps.execute();*/

            // in order to tell if the DML sucess
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }

        return 0;
    }

}
