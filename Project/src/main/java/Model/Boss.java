package Model;

public class Boss extends Monster {
	private Integer Width;
	private Integer Height;
	public Boss(Integer x, Integer y, WorldObject wObject,Integer numberMap) {
		super(x,y,wObject,numberMap);
		this.Height = 60;
		this.Width = 60;
		setHp(10*2*(numberMap+1));
	}
	
	



}
