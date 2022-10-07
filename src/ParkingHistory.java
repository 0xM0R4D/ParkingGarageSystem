import Interfaces.ParkingTicketInterface;

import java.util.ArrayList;

import Interfaces.ParkingHistoryInterface;

public class ParkingHistory implements ParkingHistoryInterface {

	private ArrayList<ParkingTicketInterface> tickets;

	public ParkingHistory() {
		this.tickets = new ArrayList<ParkingTicketInterface>();
	}

	public void addTicket(ParkingTicketInterface ticket) {
		this.tickets.add(ticket);
	}

	public Integer totalVehicles() {
		return this.tickets.size();
	}

	public float totalIncome() {
		float total = 0;

		for (ParkingTicketInterface ticket : tickets) {
			if (ticket.getSlot() == null) {
				total += ticket.calculateCost(Main.HOURLY_RATE);
			}
		}

		return total;
	}
}
