package edu.mum.domain;

import java.io.Serializable;

public class Shipment implements Serializable {

	private Long id = null;
	
	private String auctionId;

	private int version = 0;

	private String name;
	
	private double price = 0.0;

	private String description;

	public Shipment() {

	}

	public Shipment(String name, double price, String description) {
		this.name = name;
		this.setPrice(price);
		this.description = description;

	}

	// ********************** Accessor Methods ********************** //

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// ********************** Common Methods ********************** //

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Shipment))
			return false;

		final Shipment item = (Shipment) obj;

		if (name != null ? !name.equals(item.name) : item.name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (name != null ? name.hashCode() : 0);
		return result;
	}

	public String toString() {
		return 	"Item Name: " + getName() + 
				"\nItem Price:  " + getPrice() +
				"\nAuction Id: " + getAuctionId();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	
}
