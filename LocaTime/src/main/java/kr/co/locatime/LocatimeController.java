package kr.co.locatime;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.locatime.domain.ContentVO;
import kr.co.locatime.domain.MemberVO;
import kr.co.locatime.service.ContentService;
import kr.co.locatime.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class LocatimeController {
	private static final Logger logger= LoggerFactory.getLogger(LocatimeController.class);
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private ContentService contentService;
	
	//회원가입하기
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String insertMember(MemberVO memberVO,
			Model model) {
		logger.info("insert post......");
		
		try{
		
		logger.info(memberVO.toString());
		
		memberService.insertMember(memberVO);
		//성공시 1 전달.
		model.addAttribute("result","1");
		}catch(Exception e){
			//실패시 2전달.
			model.addAttribute("result","2");
		}
				
			return "member/result";
	}

	//상품등록하기
	@RequestMapping(value="/insertContent", method=RequestMethod.POST)
	public String insertContent(ContentVO contentVO, Model model) {
		logger.info("insert content post......");
		try{
		logger.info(contentVO.toString());	
		contentService.insertContent(contentVO);
		model.addAttribute("result", "1");
		}catch(Exception e){
			model.addAttribute("result", "2");
		}					
		return "member/result";
	}

	//전체 판매 가능한 상품 목록 불러오기.
	@RequestMapping(value="/selectContent",
			headers="Accept=application/json;charset=UTF-8",
			produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ContentVO> selectContent(Model model) throws Exception{
		logger.info("Show all content.........");
		return contentService.contentAll();
	}
	
	//전체 판매가능한 상품 목록 불러오기(가격순으로)
	@RequestMapping(value="/selectContentPrice",method=RequestMethod.POST)
	public void selectContentPrice(Model model) throws Exception{
		logger.info("show all content, by price asc...."+contentService.contentAllPrice().toString());
		model.addAttribute("list",contentService.contentAllPrice());
	}
	
	
	//특정 유저의 전체 상품 목록 불러오기.
	@RequestMapping(value="/selectUserContent",method=RequestMethod.POST)
	public void selectUserContent(String user_id,Model model) throws Exception{
		logger.info("Show all"+user_id+"content.........");
		List<ContentVO> list=contentService.contentAll(user_id);
		model.addAttribute("list",list);
		logger.info(list.toString());
	}
	
	
	//판매여부 업데이트 하기.
	@RequestMapping(value="/updateAble" , method=RequestMethod.POST)
	public void updateAble(ContentVO contentVO, Model model) throws Exception{
		logger.info("판매여부 업데이트 : "+contentVO.getContent_num()+" 번 상품");
		contentService.updateAble(contentVO);
	}
	
	//로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void login(MemberVO memberVO,Model model) throws Exception{
		logger.info(memberVO.getUser_id()+" login.............");		
		model.addAttribute("result",memberService.login(memberVO));
		
	}
	
	//마이페이지 정보 불러오기
	@RequestMapping(value="/myPage", method=RequestMethod.POST)
	public void myPage(String user_id,Model model) throws Exception{
		
		logger.info(user_id+"의 불러오기.");
		MemberVO memberVO=memberService.myPage(user_id);
		model.addAttribute("memberVO",memberService.myPage(user_id));
		logger.info(memberVO.toString());
	}

	//마이페이지 정보 수정하기.
	@RequestMapping(value="/updateMember", method=RequestMethod.POST)
	public void updateMember(MemberVO memberVO,
			Model model) throws Exception{
		
		logger.info(memberVO.getUser_id()+"의 정보 수정하기.");
		memberService.updateMember(memberVO);
		logger.info(memberVO.getUser_id()+"의 정보가 수정되었습니다.");
	}

	//아이디 중복확인
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	public String idCheck(String user_id,Model model)throws Exception{
		
		logger.info("idCheck");
		try{
		logger.info(user_id);	
		int result=memberService.idCheck(user_id);
		model.addAttribute("result", result);
		}catch(Exception e){
			model.addAttribute("result", "3");
		}					
		return "member/result";
	}
	
}
