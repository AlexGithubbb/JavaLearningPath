package DBTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO<T> {

    private Class<T> clazz = null;

    {
        Type superC = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superC;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        clazz = (Class<T>)actualTypeArguments[0];

    }


    public void update(Connection conn, String sql, Object ...args) {

        PreparedStatement ps = null;
        try {
             ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
             ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public T selectInstance(Connection conn, String sql, Object ...args)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

             rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            if(rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i+1);
                    Object colValue = rs.getObject(i+1);

                    Field field = t.getClass().getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, colValue);
                }

                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!= null)
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(rs != null)
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public List<T> selectForList(Connection conn, String sql, Object...args)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            ArrayList<T> ts = new ArrayList<>();
            while(rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i+1);
                    Object colValue = rs.getObject(columnLabel);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, colValue);
                }
                ts.add(t);

            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!= null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}

