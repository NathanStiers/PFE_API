package be.ipl.vinci.persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

import be.ipl.vinci.business.Configuration;
import be.ipl.vinci.business.User;

public class UserPersistence {

	private static IPersistenceBackendService backend = new PersistenceServiceImpl();

	public UserPersistence() {

	}

	public void registerUser(User u) {
		try {
			PreparedStatement ps = backend.getPreparedStatement("INSERT INTO public.\"Users\"(\"Name\", \"Surname\", \"Code\", \"Birthdate\", \"Language\", \"Dominance\", \"Schooling\", \"Schooling_level\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getSurname());
			ps.setString(3, u.getCode());
			ps.setDate(4, Date.valueOf(LocalDate.now()));
			ps.setString(5, "Francais");
			ps.setString(6, "Droitier");
			ps.setString(7, "Normal");
			ps.setString(8, "Troisième");
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Configuration getConfigForUser(User u) {
		PreparedStatement ps;
		try {
			ps = backend.getPreparedStatement("SELECT \"Need\" FROM public.\"Needs\" n WHERE \"Child\"=?");
			ps.setString(1, u.getCode());
			ResultSet rs = ps.executeQuery();
			Configuration config = new Configuration();
			while(rs.next()) {
				config.addNeed(rs.getString(1));
			}
			return config;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public boolean connectUser(User u) {
		PreparedStatement ps;
		try {
			ps = backend.getPreparedStatement("SELECT * FROM public.\"Users\" WHERE \"Code\" = ? AND \"Name\" = ?");
			System.out.println(u.getCode());
			ps.setString(1, u.getCode());
			ps.setString(2, u.getName());
			ResultSet rs = ps.executeQuery();
			return rs != null;
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
			return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllusers() {
		PreparedStatement ps;

		try {
			ps = backend.getPreparedStatement("SELECT * FROM public.\"Users\"");
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12)));
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
