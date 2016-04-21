package Model;

public class Boss extends Monster {
	private Integer Width;
	private Integer Height;
	public Boss(Integer x, Integer y, WorldObject wObject) {
		super(x,y,wObject);
		this.Height = 60;
		this.Width = 60;
	}
	
	@Override
	public Integer attack() {
		return getDegat()*getLevel();
	}


}
