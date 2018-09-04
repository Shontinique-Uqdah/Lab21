package co.grandcircus.parlor;

//import javax.persistence.Column;			Just a commented example, not used
//Switched back to jdbc so no longer using these. Here for notes
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;


//Mark all entity classes with @Entity so that Hibernate knows about them.
//@Entity
//@Table(name= "items")


public class IceCream {

	// Mark the ID, and designate that it is auto-generated
//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private int quantity;
	private float price;
	
	// The @Column annotation can be used to adjust many things about the SQL column
		// associated with a property. Just an example. Could also change other details. This changes length allowed in sql
		//@Column(length=40)
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
	
	// With Hibernate, you'll generally want to make sure you have a no-arg constructor
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
