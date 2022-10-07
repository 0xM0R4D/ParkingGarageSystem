package Interfaces;

public interface ParkingSlotInterface {
	// isOccupied function: check if ParkingSlot is occupied or no
	/**
	 * Determine if the parking slot is occupied
	 * 
	 * @return boolean
	 */
	public boolean isOccupied();

	// clearSlot function free ParkingSlot
	public void clearSlot();

	// getParkingSlotDimensions fun.
	public DimensionsInterface getDimensions();

	// setDimensions function
	public void setDimensions(float wid, float dep);

	// setOccupied fun.
	public void setOccupied(boolean oc);

	// setID fun.
	public void setID();

	// setVehicle fun.
	public void setVehicle(VehicleInterface veh);

	// getID fun.
	public int getID();

	// getVehicle fun.
	public VehicleInterface getVehicle();

	public String getDetails();

}
