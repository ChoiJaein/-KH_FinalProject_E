package com.myweb.home.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



	@Repository
	public class BoardDAO {

		
		
		@Autowired
		private SqlSession sqlSession;
	
		
		
		public int listCount() throws Exception {
			return sqlSession.selectOne("boardMapper.listCount");
		}
		
		public List<BoardDTO> listSearch(SearchCriteria scri) throws Exception {
		    return sqlSession.selectList("boardMapper.listSearch",scri);
		}
		
		public int countSearch(SearchCriteria scri) throws Exception{
			return sqlSession.selectOne("boardMapper.countSearch",scri);
		}
		
}