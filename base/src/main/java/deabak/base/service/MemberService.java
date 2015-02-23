package deabak.base.service;

import java.util.List;

import deabak.base.domain.Member;

public interface MemberService {

	public List<Member> getMembers(Member member) throws Exception;
	public Member getMember(String id) throws Exception;
	public Member createMember(Member member) throws Exception;
	public Member updateMember(Member member) throws Exception;
	public Member deleteMember(String id) throws Exception;
}
