import Interfaces.VehicleInterface;
import Interfaces.DimensionsInterface;

public class Vehicle implements VehicleInterface {
	private String ID;
	private int modelYear;
	private String modelName;
	private DimensionsInterface dimensions;

	public Vehicle() {
		this.dimensions = new Dimensions();
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public DimensionsInterface getDimensions() {
		return dimensions;
	}

	public void setDimensions(DimensionsInterface dimensions) {
		this.dimensions = dimensions;
	}

	public void setDimensions(float wid, float dep) {
		this.dimensions = new Dimensions(wid, dep);
	}

}
