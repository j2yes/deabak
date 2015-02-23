package deabak.base.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import deabak.base.domain.Member;
import deabak.base.domain.ResponseWrapper;
import deabak.base.service.MemberService;

@RestController
@RequestMapping(value="/members")
public class MemberRestController {

	@Resource(name="memberService")
	MemberService memberService;
	
	/** 목록 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseWrapper> getMembers(Member member) throws Exception{
		List members = memberService.getMembers(member); 
		ResponseWrapper wrapper = new ResponseWrapper();
		
		//실제 데이터
		wrapper.setList(members);
		
		//검색어와 페이징관련 데이터
		if(members.size()>0){
			Member memberParam = (Member)members.get(0);
			//데이터 총 row 수
			member.setTotalCount(memberParam.getTotalCount());
		}
		wrapper.setDefaultObj(member);
		
		return new ResponseEntity<ResponseWrapper>(wrapper, HttpStatus.OK);
	}
	
	/** 상세 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> getMember(@PathVariable("id") String id) throws Exception{
		Member selectedMember = memberService.getMember(id); 
		return new ResponseEntity<Member>(selectedMember,HttpStatus.OK);
	}
	
	/** 등록 */
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Member> createMemberByJson(@RequestBody Member member) throws Exception{
		Member createdMember = memberService.createMember(member); 
		return new ResponseEntity<Member>(createdMember,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Member> createMember(Member member) throws Exception{
		Member createdMember = memberService.createMember(member); 
		return new ResponseEntity<Member>(createdMember,HttpStatus.CREATED);
	}
	
	/** 수정 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Member> updateMemberByJson(@PathVariable("id") String id, @RequestBody Member member) throws Exception{
		member.setId(id);
		Member updatedMember = memberService.updateMember(member); 
		return new ResponseEntity<Member>(updatedMember,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Member> updateMember(Member member) throws Exception{
		Member updatedMember = memberService.updateMember(member); 
		return new ResponseEntity<Member>(updatedMember,HttpStatus.OK);
	}
	
	/** 삭제 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Member> deleteMember(@PathVariable("id") String id) throws Exception{
		Member deletedMember = memberService.deleteMember(id); 
		return new ResponseEntity<Member>(deletedMember,HttpStatus.OK);
	}
}
