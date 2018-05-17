package com.plzballpen;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@ComponentScan({"com.board"})    ///�ٽ�!!
@MapperScan(value = {"com.board.mapper"})
//LifeAgain�� ����ó�� Application�� Controller�� ��Ű���� �ٸ� ��쿡�� Application���� @ComponentScan({"��Ű����", "��Ű����"}) �� ���� ������� �ٸ� ��Ű������ �����ָ� �����ϳ׿�.//
public class PlzballpenApplication {

	//��ũ = http://private.tistory.com/36
	//�ּ� = http://localhost:8080/board
	public static void main(String[] args) {
		SpringApplication.run(PlzballpenApplication.class, args);
	}
	

	/**
	 *  SqlSessionFactory ����
	 */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            
            Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
            
            sessionFactory.setMapperLocations(res);
            
            return sessionFactory.getObject();
    }
    
    /**
     * HiddenHttpMethodFilter  
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        return filter;
    }

}
