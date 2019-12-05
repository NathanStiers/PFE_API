package be.ipl.vinci.business;

public class SheetItem {
	
	
	private int id; 
	private int sheetId;
	private int itemId;
	private boolean loveIt;
	private boolean needHelp;
	private boolean wannaChange;
	
	
	/**
	 * Initialize booleans to false // Pas plutot mieux de ne pas les initialiser du coup ?
	 * @param id
	 * @param sheetId
	 * @param itemId
	 */
	public SheetItem(int id, int sheetId, int itemId) {
		super();
		this.id = id;
		this.sheetId = sheetId;
		this.itemId = itemId;
//		this.loveIt = false;
//		this.needHelp = false;
//		this.wannaChange = false;
	}


	public int getId() {
		return id;
	}


	public int getSheetId() {
		return sheetId;
	}


	public int getItemId() {
		return itemId;
	}


	public boolean isLoveIt() {
		return loveIt;
	}


	public boolean isNeedHelp() {
		return needHelp;
	}


	public boolean isWannaChange() {
		return wannaChange;
	}


	public void setSheetId(int sheetId) {
		this.sheetId = sheetId;
	}


	public void setNeedHelp(boolean needHelp) {
		this.needHelp = needHelp;
	}


	public void setWannaChange(boolean wannaChange) {
		this.wannaChange = wannaChange;
	}
	
	
	
	
	
	

}
