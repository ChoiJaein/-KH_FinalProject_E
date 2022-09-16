package com.myweb.home.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class BoardDAO {

		@Autowired
		private SqlSessionTemplate sqlSession;
	
		
		
		public int listCount() throws Exception {
			return sqlSession.selectOne("boardMapper.listCount");
		}
		
		public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		    return sqlSession.selectList("boardMapper.listSearch",scri);
		}
		
		public int countSearch(SearchCriteria scri) throws Exception{
			return sqlSession.selectOne("boardMapper.countSearch",scri);
		}
		
}
