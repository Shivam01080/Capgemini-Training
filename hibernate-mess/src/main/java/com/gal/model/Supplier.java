package com.gal.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supplier")
public class Supplier {

    @Id
    @SequenceGenerator(
		    name = "suppseq",
		    sequenceName = "supplier_sequence",
		    allocationSize = 1
		)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suppseq")

    private int sid;

    private String sname;
    private double srank;
    private String city;

    @OneToMany(mappedBy = "supplier")
    private List<Supply> supplies;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSrank() {
		return srank;
	}

	public void setSrank(double srank) {
		this.srank = srank;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

}