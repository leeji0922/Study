package Product;

import Role.Role;

public class ProductBuy {
	
	private String userId;
	private String userName;
	private String productName;
	private int quantity;
	private int totalFee;
	
	
	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getTotalFee() {
		return totalFee;
	}



	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	
	
	

	public ProductBuy() {
		super();
	}

	
	

	public ProductBuy(String userName,String productName, int quantity, int totalFee) {
		super();
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return "ProductBuy [userId=" + userId + ", userName=" + userName + ", productName=" + productName
				+ ", quantity=" + quantity + ", totalFee=" + totalFee + "]";
	}

	
}