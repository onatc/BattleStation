//-------------------------------------------------------------------------
/**
*  Troop class for this program. Implements fight() function.
*
*  @author onatc6
*  @version 02/21/2018
*/

public class Troop {
	public String name;
	public int health;
	public int damage;
	public String type;
	public String preferred_target;
	public int total_damage;
	public boolean dead = false;
	
	public Troop() {
		
	}
	
	// ----------------------------------------------------------
    /**
     * Two troops attack each other and get damage according to their attributes.
     * One may die or kill the other one.
     * 
     * @param defense other troop that this troop is fighting.
     */
	public void fight(Troop defense) {
		if (preferred_target.equals(defense.type) || name.equals("Wizard")) {
			if (defense.health <= damage) {
				defense.dead = true;
				total_damage += defense.health;
			}
			else {
				total_damage += damage;
			}
			defense.health = defense.health - damage;
		}
		else {
			if (defense.health <= (damage / 2)) {
				defense.dead = true;
				total_damage += defense.health;
			}
			else {
				total_damage += damage / 2;
			}
			defense.health = defense.health - (damage / 2);
		}
		
		if (defense.preferred_target.equals(type) || defense.name.equals("Wizard")) {
			if (health <= defense.damage) {
				dead = true;
				defense.total_damage += health;
			}
			else {
				defense.total_damage += defense.damage;
			}
			health = health - defense.damage;
		}
		else {
			if (health <= (defense.damage / 2)) {
				dead = true;
				defense.total_damage += health;
			}
			else {
				defense.total_damage += defense.damage / 2;
			}
			health = health - (defense.damage / 2);

		}
	}
	
}
