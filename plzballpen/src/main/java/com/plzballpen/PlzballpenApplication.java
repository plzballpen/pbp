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
@ComponentScan({"com.board"})    ///핵심!!
@MapperScan(value = {"com.board.mapper"})
//LifeAgain님 에러처럼 Application과 Controller의 패키지가 다른 경우에는 Application에서 @ComponentScan({"패키지명", "패키지명"}) 과 같은 방법으로 다른 패키지쪽을 적어주면 동작하네요.//
public class PlzballpenApplication {

	//링크 = http://private.tistory.com/36
	//주소 = http://localhost:8080/board
	public static void main(String[] args) {
		SpringApplication.run(PlzballpenApplication.class, args);
	}
	

	/**
	 *  SqlSessionFactory 설정
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
