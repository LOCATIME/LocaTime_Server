package kr.co.locatime.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.locatime.domain.MemberVO;
import kr.co.locatime.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject 
	MemberDAO dao;
	
	@Override
	public void insertMember(MemberVO memberVO) throws Exception{
		dao.insertMember(memberVO);
	}

	@Override
	public int login(MemberVO memberVO) throws Exception {
		
		return dao.login(memberVO);
	}

	@Override
	public MemberVO myPage(String user_id) throws Exception {
		return dao.myPage(user_id);
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		dao.updateMember(memberVO);
	}

	@Override
	public int idCheck(String user_id) throws Exception {
		return dao.idCheck(user_id);
	}
	
	
	
}
