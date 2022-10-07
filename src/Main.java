import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Interfaces.VehicleInterface;
import Interfaces.ParkingSlotInterface;
import Interfaces.ParkingTicketInterface;
import Interfaces.SlotConfigurationInterface;
import Interfaces.ParkingHistoryInterface;

public class Main {
	static final int HOURLY_RATE = 5;

	public static int getConfiguration(Scanner in) {
		System.out.println("Hello Owner,choice garage configuation:");
		System.out.println("1) Best-Fit Approach");
		System.out.println("2) FIFO Approach");

		return Integer.parseInt(in.nextLine());
	}

	public static SlotConfigurationInterface getConfigurationAlgorithm(int num) {
		switch (num) {
		case 1:
			return new BestFitApproach();
		case 2:
			return new FifoApproach();

		default:
			throw new Error("Invalid configuration provided.");
		}

	}

	public static int getSlotsNumber(Scanner in) {
		System.out.println("Please, enter no. of slots");

		return Integer.parseInt(in.nextLine());
	}

	public static ParkingSlotInterface[] buildSlots(Scanner in, int slotsNum) {
		ParkingSlotInterface[] parkingSlotArr = new ParkingSlot[slotsNum];

		for (int i = 0; i < slotsNum; i++) {

			ParkingSlot slot = new ParkingSlot();

			System.out.println("Please, enter slot width: ");
			float slotWid = Float.parseFloat(in.nextLine());

			System.out.println("Please, enter slot depth: ");
			float slotDep = Float.parseFloat(in.nextLine());

			slot.setDimensions(slotWid, slotDep);

			parkingSlotArr[i] = slot;

		}

		return parkingSlotArr;
	}

	public static VehicleInterface getVehicleDetails(Scanner in) {
		VehicleInterface driveVehicle = new Vehicle();

		System.out.println("Hello Driver, Plz enter vehicle Details");
		System.out.println("Plz, enter vehicle model name:");

		String modelName = in.nextLine();
		driveVehicle.setModelName(modelName);

		System.out.println("Plz, enter vehicle model year: ");
		int modelYear = Integer.parseInt(in.nextLine());
		driveVehicle.setModelYear(modelYear);

		System.out.println("Plz, enter vehicle ID: ");
		String ID = in.nextLine();
		driveVehicle.setID(ID);

		System.out.println("Plz, enter vehicle width: ");
		float wid = Float.parseFloat(in.nextLine());

		System.out.println("Plz, enter vehicle Depth: ");
		float dep = Float.parseFloat(in.nextLine());

		driveVehicle.setDimensions(wid, dep);

		return driveVehicle;
	}

	public static int displayMainMenu(Scanner in) {
		System.out.println("==========================");
		System.out.println("Select an operation to do:");
		System.out.println("==========================");
		System.out.println("1) Park-in");
		System.out.println("2) Park-out");
		System.out.println("3) Display available slots");
		System.out.println("4) Display total vehicles number");
		System.out.println("5) Display total income amount");
		System.out.println("6) Exit");

		try {
			return Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			return -1;
		}

	}

	public static ParkingTicketInterface parkIn(Administrator admin, VehicleInterface vehicle) {
		return admin.parkIn(vehicle);
	}

	public static float parkOut(Administrator admin, ParkingTicketInterface ticket) {
		return admin.parkOut(ticket);
	}

	public static void displayAvailableSlots(Administrator admin) {
		ParkingDisplayBoard parkingDisplayBoard = new ParkingDisplayBoard();

		parkingDisplayBoard.displayAvailableSlots(admin.getParkingSlots());
	}

	public static void displayTotalVehicles(ParkingHistoryInterface history) {
		Integer count = history.totalVehicles();

		System.out.println("\n\nTotal vehicles count till now = ".concat(String.valueOf(count)).concat("\n\n"));
	}

	public static void displayTotalIncome(ParkingHistoryInterface history) {
		float count = history.totalIncome();

		System.out.println("\n\nTotal icome till now = ".concat(String.valueOf(count)).concat("\n\n"));	}

	public static void main(String[] args) {

		Scanner myIn = new Scanner(System.in);

		int choiceConfig = Main.getConfiguration(myIn);

		int slotsNum = Main.getSlotsNumber(myIn);

		SlotConfigurationInterface config = Main.getConfigurationAlgorithm(choiceConfig);

		ParkingSlotInterface[] parkingSlotArr = Main.buildSlots(myIn, slotsNum);

		Administrator admin = new Administrator(config, parkingSlotArr);

		ParkingHistoryInterface history = new ParkingHistory();

		Map<Integer, ParkingTicketInterface> tickets = new HashMap<Integer, ParkingTicketInterface>();

		while (true) {
			int choice = Main.displayMainMenu(myIn);

			switch (choice) {
			case 1: {
				VehicleInterface vehicle = Main.getVehicleDetails(myIn);

				ParkingTicketInterface ticket = Main.parkIn(admin, vehicle);

				if (ticket == null) {
					System.out.println("\n\nThere is no available slots that fits your vehicle...\n\n");
				} else {
					tickets.put(ticket.getSlot().getID(), ticket);

					history.addTicket(ticket);
				}

				break;
			}
			case 2: {
				System.out.print("Enter slot id you parked in: ");

				int slotId = Integer.parseInt(myIn.nextLine());

				ParkingTicketInterface ticket = tickets.get(slotId);

				if (ticket == null)
					System.err.println("\n\nInvalid slot ID provided!\n\n");
				else {
					float cost = Main.parkOut(admin, ticket);

					tickets.remove(slotId);

					System.out.println("\n\nParking cost = ".concat(String.valueOf(cost)).concat("\n\n"));
				}

				break;
			}
			case 3: {
				Main.displayAvailableSlots(admin);
				break;
			}
			case 4: {
				Main.displayTotalVehicles(history);
				break;
			}
			case 5: {
				Main.displayTotalIncome(history);
				break;
			}
			case 6: {
				System.out.println("\n\nExiting Program...");
				System.exit(0);
				break;
			}
			default:
				System.err.println("\n\nInvalid choice, please select one of the available choices below...\n\n");
			}

		}

	}

}
