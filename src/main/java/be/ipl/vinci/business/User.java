package be.ipl.vinci.business;

import java.time.LocalDate;

import be.ipl.vinci.persistence.IPersistenceService;
import be.ipl.vinci.persistence.PersistenceServiceImpl;
import be.ipl.vinci.persistence.UserPersistence;

public class User {

	private String name;
	private String surname;
	private String code;
	private LocalDate birthday;
	private String language;
	private String dominance;
	private String schooling;
	private String schooling_level;
	private String schooling_type; // can be null
	private int contact_one;
	private int contact_two;
	private int contact_three;
	private IPersistenceService service = new PersistenceServiceImpl();
	private UserPersistence userBack = new UserPersistence();

	public User(String name, String surname, String code, LocalDate birthday, String language, String dominance,
			String schooling, String schooling_level, int contact_one, int contact_two, int contact_three) {
		this.name = name;
		this.surname = surname;
		this.code = code;
		this.birthday = birthday;
		this.language = language;
		this.dominance = dominance;
		this.schooling = schooling;
		this.schooling_level = schooling_level;
		this.contact_one = contact_one;
		this.contact_two = contact_two;
		this.contact_three = contact_three;
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

		} catch (Exception exc) {
			System.out.println("Error in register user : " + exc);
			exc.printStackTrace();
			this.service.rollbackTransaction();
			return false;
		} finally {
			this.service.commitTransaction();
		}
		return true;

	}

	public boolean connectUser(User u) {
		try {
			this.service.startTransaction();
			if (this.userBack.connectUser(u)) {
				return true;
			}
			return false;
		} catch (Exception exc) {
			System.out.println("Error in connecting user : " + exc);
			exc.printStackTrace();
			this.service.rollbackTransaction();
			return false;
		} finally {
			this.service.commitTransaction();
		}
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
