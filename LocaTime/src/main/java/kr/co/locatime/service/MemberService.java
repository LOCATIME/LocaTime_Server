package kr.co.locatime.service;

import kr.co.locatime.domain.MemberVO;

public interface MemberService {
	public void insertMember(MemberVO memberVO) throws Exception;

	public int login(MemberVO memberVO) throws Exception;

	public MemberVO myPage(String user_id) throws Exception;

	public void updateMember(MemberVO memberVO) throws Exception;

	public int idCheck(String user_id) throws Exception;
}
