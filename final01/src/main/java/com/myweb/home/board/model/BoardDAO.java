package com.myweb.home.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class BoardDAO {

		@Autowired
		private SqlSessionTemplate sqlSession;
		
		//작성
		public void write(BoardVO vo) throws Exception{
			sqlSession.insert("boardMapper.write", vo);
		}

		//조회
		public BoardVO read(int bid) throws Exception{
			return sqlSession.selectOne("boardMapper.read", bid);
		}
		
		//목록
		public List<BoardVO> list() throws Exception{
			
			return sqlSession.selectList("boardMapper.list");
			
		}

		//페이징
		public List<BoardVO> listPage(Criteria cri) throws Exception {
			return sqlSession.selectList("boardMapper.listPage", cri);
		}
		
		
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
