package org.example.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class Mybatis01Application implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Mybatis01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("dataSource : " + dataSource);
        System.out.println("applicationContext : " + applicationContext);

        // MyBatis 호출 과정
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mappers/mapper.xml") );

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        System.out.println("sqlSession : " + sqlSession);

        String result = sqlSession.selectOne("select");
        System.out.println("result : " + result);

        sqlSession.close();
    }
}
