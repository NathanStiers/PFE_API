package be.ipl.vinci.persistence;

public interface IPersistenceService {
	
	public void startTransaction();
	public void commitTransaction();
	public void rollbackTransaction();

}
