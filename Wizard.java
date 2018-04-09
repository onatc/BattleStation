//-------------------------------------------------------------------------
/**
*  Wizard class for this program. Constructor for Wizard class with Wizard's attributes. 
*  Extends Troop class.
*
*  @author onatc6
*  @version 02/21/2018
*/
public class Wizard extends Troop {
	public Wizard() {
		health = 60;
		damage = 6;
		type = "G";
		preferred_target = "ALL";
		name = "Wizard";
		
	}
}
