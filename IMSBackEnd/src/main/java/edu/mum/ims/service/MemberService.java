package edu.mum.ims.service;

import java.util.List;
import java.util.Set;

import edu.mum.ims.domain.Member;
 
public interface MemberService {

	public void save(Member member);
	public void update(Member member);
   	public void saveFull( Member member);  		

	public List<Member> findAll();
	public Member findByMemberNumber(Integer memberId);

	public Member findOne(Long id);
	public Member findOneFull(Long id);
	
	public List<Member> findAllJoinFetch();
	public List<Member> findByGraph();
		
}
