package day2;

/**
 * @author Enrique Alonso
 */
public class Claim {
	private int id;
	private int distanceLeftMargin;
	private int distanceTopMargin;
	private int width;
	private int height;

	private Claim(final int id, final int distanceLeftMargin, final int distanceTopMargin, final int width,
			final int height) {
		this.id = id;
		this.distanceLeftMargin = distanceLeftMargin;
		this.distanceTopMargin = distanceTopMargin;
		this.width = width;
		this.height = height;
	}

	public Claim(String claimSequence){
		//#1355 @ 782,134: 14x26
		// don't want to regex, leave me alone
		try {
			String[] arr = claimSequence.replace(" ","").split("@");
			this.id = Integer.parseInt(arr[0].replace("#", ""));
			String[] arr2 = arr[1].split(":");
			String[] distances = arr2[0].split(",");
			String[] dimensions = arr2[1].split("x");
			this.distanceLeftMargin=Integer.parseInt(distances[0]);
			this.distanceTopMargin=Integer.parseInt(distances[1]);
			this.width=Integer.parseInt(dimensions[0]);
			this.height=Integer.parseInt(dimensions[1]);
		}
		catch(IndexOutOfBoundsException e){
			throw new RuntimeException("Invalid claim sequence");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getDistanceLeftMargin() {
		return distanceLeftMargin;
	}

	public void setDistanceLeftMargin(final int distanceLeftMargin) {
		this.distanceLeftMargin = distanceLeftMargin;
	}

	public int getDistanceTopMargin() {
		return distanceTopMargin;
	}

	public void setDistanceTopMargin(final int distanceTopMargin) {
		this.distanceTopMargin = distanceTopMargin;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}
}
