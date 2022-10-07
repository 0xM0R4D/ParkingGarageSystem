import Interfaces.ParkingSlotInterface;
import Interfaces.DisplayBoardInterface;

public class ParkingDisplayBoard implements DisplayBoardInterface {

	public void displayAvailableSlots(ParkingSlotInterface[] arr) {
		int emptySlots = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].isOccupied()) {
				continue;
			}

			emptySlots++;
			System.out.println(arr[i].getDetails());
		}

		if (emptySlots == 0)
			System.out.println("\n\nGarage has no available slots at the moment...\n\n");
	}

}
