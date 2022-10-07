import Interfaces.DimensionsInterface;

public class Dimensions implements DimensionsInterface {
	private float width;
	private float depth;

	public Dimensions() {
		this.width = 0;
		this.depth = 0;
	}

	public Dimensions(float width, float depth) {
		this.width = width;
		this.depth = depth;
	}

	// setWidth function
	public void setWidth(float wid) {
		width = wid;
	}

	// setDepth function
	public void setDepth(float dep) {
		depth = dep;
	}

	// getDepth function
	public float getWidth() {
		return width;
	}

	// getDepth function
	public float getDepth() {
		return depth;
	}

}
