package Product;

import Role.Role;

public class Product {
	
	private String productName;
	private int cost;
	private int stock;
	private Role role;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Product() {
		super();
	}
	public Product(String productName, int cost, int stock) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.stock = stock;
	}
	public Product(String productName, int cost, int stock, Role role) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.stock = stock;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", cost=" + cost + ", stock=" + stock + "]";
	}
	
}