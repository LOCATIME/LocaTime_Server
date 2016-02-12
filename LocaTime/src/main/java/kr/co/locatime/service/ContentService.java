package kr.co.locatime.service;

import java.util.List;

import kr.co.locatime.domain.ContentVO;

public interface ContentService {
	public void insertContent(ContentVO contentVO) throws Exception;
	public List<ContentVO> contentAll() throws Exception;
	public List<ContentVO> contentAllPrice() throws Exception;
	public List<ContentVO> contentAll(String user_id) throws Exception;
	public void updateAble(ContentVO contentVO) throws Exception;
}
