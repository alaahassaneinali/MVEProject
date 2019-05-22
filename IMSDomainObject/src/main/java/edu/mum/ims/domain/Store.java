package edu.mum.ims.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Store implements Serializable {
	
	/**
	 * This is to fix java.io.InvalidClassException: local class incompatible
	 * which occurs when serialize and de-serialize object sending between client and server
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
     private long id;
	private String name;
	
	@OneToOne
    private Address address;
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Store [name=" + name + ", address=" + address.toString() + "]";
	}
		
}
