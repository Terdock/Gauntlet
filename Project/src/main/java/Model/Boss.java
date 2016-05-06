package Model;

public class Boss extends Monster {
	public Boss(Integer x, Integer y, WorldObject wObject,Integer numberMap) {
		super(x,y,wObject,numberMap);
		setHp(true,10000*(numberMap+1));
	}
}
