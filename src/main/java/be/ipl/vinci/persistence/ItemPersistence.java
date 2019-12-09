package be.ipl.vinci.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.ipl.vinci.business.Item;

public class ItemPersistence {

	private static IPersistenceBackendService backend = new PersistenceServiceImpl();

	public List<Item> getAllItems() {

		PreparedStatement ps;

		try {
			ps = backend.getPreparedStatement("SELECT * FROM public.\"Items\"");
			ResultSet rs = ps.executeQuery();
			if (rs.getFetchSize() <= 0) {
				return null;
			}
			List<Item> toReturn = new ArrayList<Item>();
			do {
				toReturn.add(new Item(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			} while (rs.next());

			return toReturn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
