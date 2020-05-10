package jdbc_Dao;

/* get instance
*  get list
*  update list
* */


import jdbc_Dao.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {


    // get single instance
    public  <T> T getInstance(Connection connection, Class<T> clazz, String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = connection.prepareStatement(sql);

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
            JDBCUtils.closeResource(null, ps, resultSet);
        }

        return null;
    }

    // get date set
    public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object ...args){

        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);

            // 处理占位符 '？'
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            ArrayList<T> ts = new ArrayList<>();
            while(resultSet.next()){
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
                ts.add(t);
            }

            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }

    // update table
    public int update(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        try {

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
            JDBCUtils.closeResource(null, ps);
        }

        return 0;
    }

    // get generic value
    public <E> E getValue(Connection conn, String sql, Object ...args) {

        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();

            if(resultSet.next()){
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }

}
