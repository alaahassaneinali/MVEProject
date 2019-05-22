package edu.mum.ims.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;

@Entity
@Table(name = "shipment")
 
public class Shipment implements Serializable{
	
	
	  @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id = null;
	   @Version
	   @Column(name = "version")
	   private int version = 0;

	   @Column
	   private String shipmentNumber;
	   
	   @Column
	   private ShipmentComp shipComp;   

	   @Column
	   private Date shipmentDate;
	   @Column
	   private Date deliveryDate;	   
       
	   @ManyToOne(fetch=FetchType.EAGER)
	   @JoinColumn (name="store_id") 
	   private Store store;

	   @OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	   private Set<ShipmentItem> items = new HashSet<ShipmentItem>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getShipmentNumber() {
		return shipmentNumber;
	}

	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	
	public ShipmentComp getShipComp() {
		return shipComp;
	}

	public void setShipComp(ShipmentComp shipComp) {
		this.shipComp = shipComp;
	}

	public Set<ShipmentItem> getItems() {
		return items;
	}

	public void setItems(Set<ShipmentItem> items) {
		this.items = items;
	}	

	public void addShipmentItem(ShipmentItem shipmentItem) {
		this.items.add(shipmentItem);
		shipmentItem.setShipment(this);
	}
}
