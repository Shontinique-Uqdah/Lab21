package co.grandcircus.parlor;

public class IceCream {

	private Long id;
	private String name;
	private String description;
	private int quantity;
	private float price;
	private String category;
	private String image;
	
	
	public IceCream(String name, String description, int quantity, float price, String category, String image) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.image = image;
	}
	
	public IceCream() {
		
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
