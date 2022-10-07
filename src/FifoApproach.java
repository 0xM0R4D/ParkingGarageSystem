import Interfaces.VehicleInterface;
import Interfaces.DimensionsInterface;
import Interfaces.ParkingSlotInterface;
import Interfaces.SlotConfigurationInterface;

public class FifoApproach implements SlotConfigurationInterface {

	public ParkingSlotInterface apply(VehicleInterface vehicle, ParkingSlotInterface[] parkSlotsArr) {

		int n = parkSlotsArr.length;

		ParkingSlotInterface availableSlot = null;

		DimensionsInterface vehDimensions = new Dimensions();

		vehDimensions = vehicle.getDimensions();

		float vehWid = vehDimensions.getWidth();
		float vehDep = vehDimensions.getDepth();

		for (int i = 0; i < n; i++) {
			DimensionsInterface di = new Dimensions();
			di = parkSlotsArr[i].getDimensions();
			float slotWid = di.getWidth();
			float slotDep = di.getDepth();
			if (!parkSlotsArr[i].isOccupied() && slotWid > vehWid && slotDep > vehDep) {
				parkSlotsArr[i].setOccupied(true);

				availableSlot = parkSlotsArr[i];
				break;
			}
		}

		return availableSlot;
	}
}
