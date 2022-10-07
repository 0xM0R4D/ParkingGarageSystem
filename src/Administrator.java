import Interfaces.VehicleInterface;
import Interfaces.ParkingSlotInterface;
import Interfaces.ParkingTicketInterface;
import Interfaces.SlotConfigurationInterface;

public class Administrator {

	private ParkingSlotInterface[] parkSlotsArr;
	private SlotConfigurationInterface algorithm;

	// Parameterize constructor
	public Administrator(SlotConfigurationInterface configAlgorithm, ParkingSlotInterface[] arr) {
		this.algorithm = configAlgorithm;
		this.parkSlotsArr = arr;
	}

	// parkIn fun.
	public ParkingTicketInterface parkIn(VehicleInterface vehicle) {

		ParkingSlotInterface availableSlot = this.algorithm.apply(vehicle, this.parkSlotsArr);

		if (availableSlot == null) {
			return null;
		}
		
		availableSlot.setOccupied(true);

		// create ticket and set it availableSlot and InTime
		ParkingTicketInterface ticket = new ParkingTicket();
		ticket.setSlot(availableSlot);
		ticket.setInTime();

		return ticket;
	}

	// parkOut fun.
	public float parkOut(ParkingTicketInterface ticket) {
		ticket.getSlot().setOccupied(false);

		ticket.setOutTime();
		
		ticket.setSlot(null);

		return ticket.calculateCost(Main.HOURLY_RATE);
	}

	// setParkingSlotArr fun.
	public void setParkingSlots(ParkingSlotInterface[] arr) {
		this.parkSlotsArr = arr;
	}

	// getParkingSlotArr fun.
	public ParkingSlotInterface[] getParkingSlots() {
		return this.parkSlotsArr;
	}

}
