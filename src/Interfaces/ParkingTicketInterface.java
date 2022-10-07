package Interfaces;

import java.util.Date;

public interface ParkingTicketInterface {

	public void setSlot(ParkingSlotInterface sl);

	public void setInTime();

	public void setOutTime();

	public Date getInTime();

	public Date getOutTime();

	public ParkingSlotInterface getSlot();

	public float calculateDuration();

	public float calculateCost(float rate);
}
