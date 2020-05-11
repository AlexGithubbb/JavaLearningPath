package jdbc_Dao3;

/* get instance
*  get list
*  update list
* */


import jdbc_Dao.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {

    private Class<T> clazz = null;

    // 获取当前BaseDAO的子类的父类中的泛型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        // 吧泛型赋给 clazz
        clazz = (Class<T>) actualTypeArguments[0]; // 泛型的第一个参数
    }


    // get single instance
    public T getInstance(Connection connection, String sql, Object...args) {

        try {
            QueryRunner queryRunner = new QueryRunner();

            BeanHandler beanHandler = new BeanHandler<>(clazz);
            Object query = queryRunner.query(connection, sql, beanHandler, args);

            return (T) query;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // get date set
    public List<T> getForList(Connection conn, String sql, Object ...args){


        try {
            QueryRunner queryRunner = new QueryRunner();

            BeanListHandler beanListHandler = new BeanListHandler<>(clazz);
            Object list = queryRunner.query(conn, sql, beanListHandler, args);

            return (List<T>) list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // update table
    public int update(Connection conn, String sql, Object ...args) {

        try {

            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(conn, sql, args);

        } catch (Exception e) {
            e.printStackTrace();
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


    public static void closeResource(Connection con, ResultSet rs, PreparedStatement ps){
        DbUtils.closeQuietly(con);
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(ps);
    }

}
