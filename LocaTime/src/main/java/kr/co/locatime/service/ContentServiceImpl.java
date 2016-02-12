package kr.co.locatime.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.locatime.domain.ContentVO;
import kr.co.locatime.persistence.ContentDAO;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Inject
	ContentDAO dao;
	
	@Override
	public void insertContent(ContentVO contentVO) throws Exception {
		dao.insertContent(contentVO);
	}

	@Override
	public List<ContentVO> contentAll() throws Exception {
		return dao.contentAll();
	}
	
	
	

	@Override
	public List<ContentVO> contentAllPrice() throws Exception {
		
		return dao.contentAllPrice();
	}

	@Override
	public List<ContentVO> contentAll(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.contentAll(user_id);
	}

	@Override
	public void updateAble(ContentVO contentVO) throws Exception {
		dao.updateAble(contentVO);
	}
	
	
}
