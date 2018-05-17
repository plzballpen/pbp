package com.plzballpen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlzballpenApplicationTests {

	/*
    @Autowired
    private DataSource ds; //작성
 
    @Autowired
    private SqlSessionFactory sqlSession; //실행테스트
    */
    @Autowired
    private BoardMapper mapper;

    @Test
    public void contextLoads() {
    }
 
    @Test
    public void testConnection() throws Exception{ //작성
    	/*
        System.out.println("ds : "+ds);       
        Connection con = ds.getConnection(); //ds(DataSource)에서 Connection을 얻어내고
        System.out.println("con : "+con); //확인 후        
        con.close(); //close
        */
    	
    	//System.out.println("sqlSession :"+sqlSession);
    	
    	BoardVO vo = new BoardVO();
    	vo.setSubject("제목입니다.");
    	vo.setContent("내용입니다.");
    	vo.setWriter("작성자입니다.");
    	
    	mapper.boardInsert(vo);
    }

}
