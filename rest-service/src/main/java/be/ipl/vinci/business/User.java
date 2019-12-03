package be.ipl.vinci.business;

import be.ipl.vinci.persistence.IPersistenceService;
import be.ipl.vinci.persistence.PersistenceServiceImpl;
import be.ipl.vinci.persistence.UserPersistence;

public class User {

	private String name;
	private String surname;
	private String code;
	private IPersistenceService service = new PersistenceServiceImpl();
	private UserPersistence userBack = new UserPersistence();
	
	public User(String name, String surname, String code) {
		this.name = name;
		this.surname = surname;
		this.code = code;
		this.service = new PersistenceServiceImpl();
		this.userBack = new UserPersistence();
	}

	public User() {
		super();
	}
	public boolean registerUser(User u) {
		try {
			this.service.startTransaction();
			this.userBack.registerUser(u);
			
		}catch (Exception exc) {
			System.out.println("Error in register user : " + exc);
			exc.printStackTrace();
			this.service.rollbackTransaction();
			return false;
		} finally {
			this.service.commitTransaction();
		}
		return true;		
		
	}
	

	public String getName() {
		return name;
	}


	public String getSurname() {
		return surname;
	}


	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.surname + " " + this.code;
	}
	
	
	
	
	
}
