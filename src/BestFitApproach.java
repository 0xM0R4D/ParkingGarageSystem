import Interfaces.VehicleInterface;
import Interfaces.DimensionsInterface;
import Interfaces.ParkingSlotInterface;
import Interfaces.SlotConfigurationInterface;

public class BestFitApproach implements SlotConfigurationInterface {

	public ParkingSlotInterface apply(VehicleInterface vehicle, ParkingSlotInterface[] parkSlotsArr) {
		DimensionsInterface vehDimensions = vehicle.getDimensions();
		ParkingSlotInterface availableSlot = null;
		DimensionsInterface mn = new Dimensions();

		float vehWid = vehDimensions.getWidth();
		float vehDep = vehDimensions.getDepth();

		mn.setDepth(1000000);
		mn.setWidth(1000000);

		int n = parkSlotsArr.length;

		int intialIdx = -1;

		for (int i = 0; i < n; i++) {
			DimensionsInterface slotDie = parkSlotsArr[i].getDimensions();
			float slotWid = slotDie.getWidth();
			float slotDep = slotDie.getDepth();

			if (!parkSlotsArr[i].isOccupied() && slotWid > vehWid && slotWid < mn.getWidth() && slotDep > vehDep
					&& slotDep < mn.getDepth()) {
				mn.setWidth(slotWid);
				mn.setDepth(slotDep);
				availableSlot = parkSlotsArr[i];
				parkSlotsArr[i].setOccupied(true);
				if (intialIdx != -1) {
					parkSlotsArr[intialIdx].setOccupied(false); // free last slot
				}
				intialIdx = i;
			}
		}

		return availableSlot;
	}
}
