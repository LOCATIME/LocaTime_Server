package kr.co.locatime.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.locatime.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="kr.co.locatime.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert(namespace+".insertMember",memberVO);
		
	}

	@Override
	public int login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".login",memberVO);
	}

	@Override
	public MemberVO myPage(String user_id) throws Exception {
		MemberVO memberVO=new MemberVO();
		memberVO.setUser_id(user_id);
		return sqlSession.selectOne(namespace+".myPage", memberVO);
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		sqlSession.update(namespace+".updateMember",memberVO);
	}

	@Override
	public int idCheck(String user_id) throws Exception {
		return sqlSession.selectOne(namespace+".idCheck",user_id);
	}
	
	
	
}
