package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable{
	
	private String id, name, imgpath;
	private double price;
	private int qty;
	
	public ProductBean() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", imgpath=" + imgpath + ", price=" + price + ", qty=" + qty
				+ "]";
	} 
	
	
	
	
	
	

}
