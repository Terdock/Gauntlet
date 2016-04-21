package Model;

public class KeyHolder extends Monster {
	private Integer Width;
	private Integer Height;
	public KeyHolder(Integer x, Integer y, WorldObject wObject) {
		super(x,y,wObject);
		this.Height = 32;
		this.Width = 32;
	}
}
