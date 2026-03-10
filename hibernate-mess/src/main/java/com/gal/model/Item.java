package com.gal.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Item")
public class Item {
    
	@Id
	@SequenceGenerator(
		    name = "itemseq",
		    sequenceName = "item_sequence",
		    allocationSize = 1
		)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	
    private int itemid;

    public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	private String name;
    private String type;

    @OneToMany(mappedBy = "item")
    private List<Supply> supplies;

}