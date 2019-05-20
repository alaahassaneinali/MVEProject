package edu.mum.ims.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.ims.domain.Member;
import edu.mum.ims.domain.Product;

@Component
public interface MemberRestService {

 	public List<Member> findAll();

	public Member findOne(Long index);

	public Member save(Member member);

}
