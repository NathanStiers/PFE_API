package be.ipl.vinci.business;

import java.time.LocalDate;

public class Sheet {

	private int id; 
	private String user;
	private LocalDate date;
	
	public Sheet(int id, String user, LocalDate date) {
		this.id = id;
		this.user = user;
		this.date = date;
	}
	
	/**
	 * Initialize date at current date
	 * @param id
	 * @param user
	 */
	public Sheet(int id, String user) {
		this.id = id;
		this.user = user;
		this.date = LocalDate.now();
	}
	
}
