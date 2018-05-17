package com.board.mapper;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardMapper {
	//���ۼ�
    public void boardInsert(BoardVO board)throws Exception;
    
    //�۸��
    public List<BoardVO> boardList() throws Exception; //�߰�
    
    //�ۺ���
    public BoardVO boardView(int bto) throws Exception;
    
    //��ȸ�� ����
    public void hitPlus(int bno) throws Exception;
    
    //�ۼ���
    public void boardUpdate(BoardVO vo) throws Exception;
    
    //�ۻ���
    public void boardDelete(int bno) throws Exception;
}
