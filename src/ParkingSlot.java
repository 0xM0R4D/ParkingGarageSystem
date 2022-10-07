import Interfaces.VehicleInterface;
import Interfaces.DimensionsInterface;
import Interfaces.ParkingSlotInterface;

public class ParkingSlot implements ParkingSlotInterface {
	private static int automaticID = 1;
	private int slotID;
	private boolean occupied = false;
	private VehicleInterface vehicle;
	private DimensionsInterface dimensions;

	ParkingSlot() {
		setID();
	}

	// isOccupied function: check if ParkingSlot is occupied or no
	public boolean isOccupied() {
		return occupied;
	}

	// clearSlot function free ParkingSlot
	public void clearSlot() {
		occupied = false;

		this.vehicle = null;
	}

	// getParkingSlotDimensions fun.
	public DimensionsInterface getDimensions() {
		return dimensions;
	}

	// setDimensions function
	public void setDimensions(float wid, float dep) {
		this.dimensions = new Dimensions(wid, dep);
	}

	// setOccupied fun.
	public void setOccupied(boolean oc) {
		occupied = oc;
	}

	// setID fun.
	public void setID() {
		slotID = automaticID;
		automaticID++;
	}

	// setVehicle fun.
	public void setVehicle(VehicleInterface veh) {
		vehicle = veh;
	}

	// getID fun.
	public int getID() {
		return slotID;
	}

	// getVehicle fun.
	public VehicleInterface getVehicle() {
		return vehicle;
	}

	public String getDetails() {
		return "Slot ID = ".concat(String.valueOf(this.slotID));

	}

}
