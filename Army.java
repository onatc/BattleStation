import java.util.Vector;

//-------------------------------------------------------------------------
/**
*  Army class for this program. Creates the army, adds troops, finds the outstanding troop.
*
*  @author onatc6
*  @version 02/21/2018
*/
public class Army {
	
	public int size = 20;		//size of the army
	public Vector<Troop> army = new Vector<Troop>();	//Vector that holds the troops
	
    /**
     * Add a single troop to the army
     * 
     * @param trp Troop to be added
     */
	public void addTroop(Troop trp) {
		if(army.size() < size) {
			army.add(trp);
		}
	}
	
	/**
     * Fill the army with the given sequence until the army is full
     * 
     * @param sequence The sequence used (ex. MWBF) Monkey, Wizard, Balloon, Flying Monkey
     */
	public void fillArmy(String sequence) {
		int i = 0;
		while (army.size() < size) {
			if (i < sequence.length()) {
				if (sequence.charAt(i) == 'M') {
					army.add(new Monkey());
				}
				else if (sequence.charAt(i) == 'F') {
					army.add(new FlyingMonkey());
				}
				else if (sequence.charAt(i) == 'W') {
					army.add(new Wizard());
				}
				else if (sequence.charAt(i) == 'B') {
					army.add(new Balloon());
				}
				i++;
			}
			else {
				i = 0;
			}
		}
	}
	
	/**
     * Remove the troop from the army if it's dead
     * 
     * @param i Index of the troop that is dead
     */
	public void removeUponDeath(int i) {
		if(army.get(i).dead) {
			army.remove(i);
		}
	}
	
	/**
     * Print the troops in the army
     */
	public void printArmy() {
		for (int i = 0; i < army.size(); i++) {
			System.out.println((i + 1) + ". " + army.get(i).name);
		}
	}
	
	
	/**
     * Print troops in the army with their health and total damage
     */
	public void printArmyFull() {
		for (int i = 0; i < army.size(); i++) {
			System.out.println((i + 1) + ". " + army.get(i).name + ", " + "health=" + army.get(i).health + ", totalDamage=" + army.get(i).total_damage);
		}
	}
	
	/**
     * Basic isEmpty() function
     * 
     */
	public boolean isEmpty() {
		return(army.isEmpty());
	}
	
	/**
     * Basic size() function showing army size
     * 
     */
	public int size() {
		return(army.size());
	}
	
	/**
     * Gets the troop by its index
     * 
     * @param i Index of the troop
     */
	public Troop getTroop(int i) {
		return army.get(i);
	}
	
	/**
     * Returns outstanding troop
     * 
     */
	public Troop getOutstandingTroop() {
        int count = 0;
        int largest = 0;
        Troop largest_troop = new Troop();
        for (int i = 0; i < army.size(); i++) {
        	int x = army.get(i).total_damage;
        	while (x!=0)
            {
                x = (x & (x << 1));
     
                count++;
            }
        	if (count > largest) { 
        		largest = count;
        		largest_troop = army.get(i);
        	}
        }
        
        return largest_troop;
    
	}
	
}
