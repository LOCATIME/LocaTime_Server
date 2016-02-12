package kr.co.locatime.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.locatime.domain.ContentVO;


@Repository
public class ContentDAOImpl implements ContentDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="kr.co.locatime.mapper.ContentMapper";
	
	
	@Override
	public void insertContent(ContentVO contentVO) {
		sqlSession.insert(namespace+".insertContent",contentVO);
	}


	@Override
	public List<ContentVO> contentAll() throws Exception {
		return sqlSession.selectList(namespace+".contentAll");
	}

	

	@Override
	public List<ContentVO> contentAllPrice() throws Exception {
		return sqlSession.selectList(namespace+".contentAllPrice");
	}


	@Override
	public List<ContentVO> contentAll(String user_id) throws Exception {
		return sqlSession.selectList(namespace+".contentAll_user",user_id);
	}


	@Override
	public void updateAble(ContentVO contentVO) throws Exception {
		sqlSession.update(namespace+".updateAble",contentVO);
	}
	
	
	
}
