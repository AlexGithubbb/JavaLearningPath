package myBatis;

import myBatis.bean.Student;
import myBatis.dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "myBatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return  sqlSessionFactory;

    }

    @Test
    public void test() throws IOException {
        String resource = "myBatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession session =null;


        try {
            session = sqlSessionFactory.openSession();
            Student student = session.selectOne("org.mybatis.example.StudentMapper.selectStd", 1);
            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(session!= null)
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testInterfaceMethod() throws IOException {
        // get sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        // get session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            // get object of interface
            // mybatis will create a proxy object for us, so we can use the method from interface
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStdById(2);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }


}
