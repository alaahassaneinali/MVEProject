package edu.mum.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.ims.domain.Member;
import edu.mum.ims.rest.service.MemberRestService;

@Service
public class MemberServiceImpl implements edu.mum.ims.service.MemberService {
	
 	@Autowired
	private MemberRestService memberRestService;

     public void save( Member member) {  		
    	memberRestService.save(member);
	}
		
    @Override
   	public void saveFull( Member member) {  		
//  		credentialsService.save(member.getUserCredentials());
  		memberRestService.save(member);
	}
  	

	public List<Member> findAll() {
		return (List<Member>)memberRestService.findAll();
	}

 
	public Member findOne(Long id) {
		return memberRestService.findOne(id);
	}
	
 
	
 }
