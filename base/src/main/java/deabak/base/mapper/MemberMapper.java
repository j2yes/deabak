package deabak.base.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import deabak.base.domain.Member;

@Repository("memberMapper")
public interface MemberMapper {

	public List<Member> getMembers(Member member) throws Exception;
	public Member getMember(String id) throws Exception;
	public void createMember(Member member) throws Exception;
	public void updateMember(Member member) throws Exception;
	public void deleteMember(String id) throws Exception;
}
