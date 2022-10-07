import java.util.Date;
import Interfaces.ParkingSlotInterface;
import Interfaces.ParkingTicketInterface;

public class ParkingTicket implements ParkingTicketInterface {
	private Date inTime;
	private Date outTime;
	private ParkingSlotInterface slot;

	public void setSlot(ParkingSlotInterface sl) {
		slot = sl;
	}

	public void setInTime() {
		this.inTime = new Date();
	}

	// setOutTime fun.
	public void setOutTime() {
		this.outTime = (new Date());

		// this.outTime.setHours(7);
	}

	// getInTime fun.
	public Date getInTime() {
		return inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	// getSlot fun.
	public ParkingSlotInterface getSlot() {
		return slot;
	}

	/**
	 * Get parking duration in hours.
	 */
	public float calculateDuration() {
		return (this.outTime.getTime() - this.inTime.getTime()) / 1000 / 60 / 60;
	}

	/**
	 * Calculate the ticket cost based on the given hourly rate.
	 */
	public float calculateCost(float rate) {
		return (rate * this.calculateDuration());
	}

}
