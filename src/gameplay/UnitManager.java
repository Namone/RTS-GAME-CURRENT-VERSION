package gameplay;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Rectangle;

public class UnitManager extends Units {
	
	protected UNITS currentUnit;
	protected Units unit;
	protected String unitName;
	
	public UnitManager(String unitName, float x, float y) {
		posX = x;
		posY = y;
		name = unitName;
	}

	@Override
	public Units getUnit() {
		
		switch (name) {
		case "civilian":
			currentUnit = UNITS.CIVILIAN;
			Units civ = new Civilian(posX, posY);
			return civ;
		case "soldier":
			currentUnit = UNITS.SOLDIER;
			break;
		case "priest":
			currentUnit = UNITS.PRIEST;
			break;
		case "architect":
			currentUnit = UNITS.ARCHITECT;
			break;
		}
		return null;
	}

	@Override
	public void moveUnit() {
		
	}

	@Override
	public void createUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void healUnit(int hpPointsToHeal) {

		
	}

	@Override
	public void drawUnit() {
		unit.drawUnit();		
	}	

}
