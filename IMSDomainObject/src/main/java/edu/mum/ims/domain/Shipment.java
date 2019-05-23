package edu.mum.ims.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;

@Entity
@Table(name = "purchaseShipment")

public class Shipment implements Serializable {

	/**
	 * This is to fix java.io.InvalidClassException: local class incompatible
	 * which occurs when serialize and de-serialize object sending between client and server
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	public Shipment() {
		
	}
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
	private String shipmentDate;
	@Column
	private String deliveryDate;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	private Store store;

	
	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	@OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ShipmentItem> items = new HashSet<ShipmentItem>();

	@Transient
	private Long productId;	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
		
	@Transient
	private int quantity;	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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
