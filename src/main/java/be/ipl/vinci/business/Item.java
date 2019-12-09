package be.ipl.vinci.business;

public class Item {

	private int id;
	private int category;
	private String image;
	private String name;
	private String note;

	public Item(int id, int category, String image, String name, String note) {
		this.id = id;
		this.category = category;
		this.image = image;
		this.name = name;
		this.note = note;
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
}
