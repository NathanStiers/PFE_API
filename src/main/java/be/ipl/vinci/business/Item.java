package be.ipl.vinci.business;

public class Item {

	private int id; 
	private int category; 
	private String image; 
	private String name;
	private boolean favorite; //init at false
	
	public Item(int id, int category, String image, String name) {
		this.id = id; 
		this.category = category;
		this.image = image;
		this.name = name;
		this.favorite = false;
	}

	public int getId() {
		return id;
	}

	public int getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	
	
	
	
}
