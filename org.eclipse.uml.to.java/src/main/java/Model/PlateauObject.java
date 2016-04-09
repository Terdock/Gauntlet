package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private int Height = 30;
	private int Width = 30;
	private boolean passable;
	
	public PlateauObject(int pos_x, int pos_y, boolean passable) {
		super(pos_x, pos_y);
		this.passable = passable;
		// TODO Auto-generated constructor stub
	}



	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}
	
	

}
