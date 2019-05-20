package edu.mum.ims.service;

import java.util.List;

import edu.mum.ims.domain.Address;
 
public interface AddressService {

	public void save(Address address);
	public void update(Address address);
	public List<Address> findAll();
 
	public Address findOne(Long id);

}
