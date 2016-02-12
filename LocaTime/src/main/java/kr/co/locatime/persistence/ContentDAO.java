package kr.co.locatime.persistence;

import java.util.List;

import kr.co.locatime.domain.ContentVO;

public interface ContentDAO {
	public void insertContent(ContentVO contentVO) throws Exception;
	public List<ContentVO> contentAll() throws Exception;
	public List<ContentVO> contentAllPrice() throws Exception;
	public List<ContentVO> contentAll(String user_id) throws Exception;
	public void updateAble(ContentVO contentVO) throws Exception;
}
