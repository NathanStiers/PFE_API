package be.ipl.vinci.persistence;

import java.sql.PreparedStatement;

import be.ipl.vinci.business.User;

public class UserPersistence {
	
	
	
	private static IPersistenceBackendService backend = new PersistenceServiceImpl();
	
	
	public UserPersistence () {
		
	}
	
	public void registerUser(User u) {
		try {
			PreparedStatement ps = backend.getPreparedStatement("INSERT INTO public.\"Users\"(\"Name\", \"Surname\", \"Code\") VALUES (?, ?, ?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getSurname());
			ps.setString(3, u.getCode());
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
