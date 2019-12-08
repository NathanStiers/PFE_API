package be.ipl.vinci.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			e.printStackTrace();
		}
	}

	public boolean connectUser(User u) {
		PreparedStatement ps;
		try {
			ps = backend.getPreparedStatement("SELECT * FROM public.\"Users\" WHERE code = ? AND name = ?");
			ps.setString(1, u.getCode());
			ps.setString(2, u.getName());
			return ps.getFetchSize() == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User getAllInfo(String code) {
		PreparedStatement ps;
		
		try {
			ps = backend.getPreparedStatement("SELECT * FROM public.\"Users\" WHERE \"Code\" = ?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
