package model.entities;

public class Products {
	private String product, brand;
	private Double price;
	private Integer qty;

	public Products() {

	}

	public Products(String product, String brand, Double price, Integer qty ) {
		this.product = product;
		this.brand = brand;
		this.price = price;
		this.qty = qty;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		StringBuilder product = new StringBuilder();

		product.append(this.product + ",");
		product.append(this.brand + ",");
		product.append(this.price + ",");
		product.append(this.qty + "\n");

		return product.toString();
	}

}
