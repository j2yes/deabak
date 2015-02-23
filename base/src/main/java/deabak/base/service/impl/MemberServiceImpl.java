package deabak.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import deabak.base.domain.Member;
import deabak.base.mapper.MemberMapper;
import deabak.base.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberMapper")
	MemberMapper memberMapper;
	
	@Override
	public List<Member> getMembers(Member member) throws Exception {
		return memberMapper.getMembers(member);
	}

	@Override
	public Member getMember(String id) throws Exception {
		return memberMapper.getMember(id);
	}

	@Override
	public Member createMember(Member member) throws Exception {
		memberMapper.createMember(member);
		return getMember(member.getId());
	}

	@Override
	public Member updateMember(Member member) throws Exception {
		memberMapper.updateMember(member);
		return getMember(member.getId());
	}

	@Override
	public Member deleteMember(String id) throws Exception {
		memberMapper.deleteMember(id);
		return new Member();
	}

}
