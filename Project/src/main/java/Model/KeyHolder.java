package Model;

public class KeyHolder extends Monster {
	private Integer Width;
	private Integer Height;
	public KeyHolder(Integer x, Integer y, WorldObject wObject,Integer numberMap) {
		super(x,y,wObject, numberMap);
		this.Height = 32;
		this.Width = 32;
		setHp(10*2*(numberMap+1));
	}
}
