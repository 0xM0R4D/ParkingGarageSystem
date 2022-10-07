package Interfaces;

public interface VehicleInterface {

	public void setDimensions(float wid, float dep);

	// setModelYear function
	public void setModelYear(int mYear) ;

	// setModelName fun.
	public void setModelName(String mName) ;

	// setID fun.
	public void setID(String id);

	// getters
	// getID function
	public String getID() ;

	// getModelYear fun.
	public int getModelYear();

	// getModelName fun.
	public String getModelName();

	// getVehicleDimensions fun.
	public DimensionsInterface getDimensions();
}
