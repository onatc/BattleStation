//-------------------------------------------------------------------------
/**
*  BattleStation class for this program. Implements main function with required outputs and army.
*
*  @author onatc6
*  @version 02/21/2018
*/

public class BattleStation {
	public static void main(String[] args) {
		Army army1 = new Army();
		Army army2 = new Army();
		
		army1.fillArmy("MFWB");		//fills army 1 with sequence Monkey, Flying Monkey, Wizard, Balloon
		army2.fillArmy("FWBM");		//fills army 2 with sequence Flying Monkey, Wizard, Balloon, Monkey
		
		//Print initial troops
		System.out.println("Army 1 - Initial Troops:");
		army1.printArmy();
		System.out.println("\n");
		System.out.println("Army 2 - Initial Troops:");
		army2.printArmy();
		
		System.out.println("\nBATTLE");
		int round = 0; //track rounds
		int i1 = 0;	//track troops in army 1
		int i2 = 0;	//track troops in army 2
		
		//Battle
		while (!army1.isEmpty() && !army2.isEmpty()) {
			if(i1 >= army1.size()) {
				i1 = 0;
			}
			if (i2 >= army2.size()) {
				i2 = 0;
			}
			System.out.println("Round " + (round + 1) + ": Player 1 " + army1.getTroop(i1).name + "(health=" + army1.getTroop(i1).health + ",totalDamage=" + army1.getTroop(i1).total_damage +
					") vs. Player 2 " + army2.getTroop(i2).name + "(health=" + army2.getTroop(i2).health + ",totalDamage=" + army2.getTroop(i2).total_damage + ")");
			
			army1.getTroop(i1).fight(army2.getTroop(i2));
			
			if (army1.getTroop(i1).dead) {System.out.println("	  Player 1 " + army1.getTroop(i1).name + " was killed");}
			if (army2.getTroop(i2).dead) {System.out.println("	  Player 2 " + army2.getTroop(i2).name + " was killed");}
			
			army1.removeUponDeath(i1);
			army2.removeUponDeath(i2);
			round++;
			i1++;
			i2++;
		}
		
		
		//Show the winner
		if (army1.isEmpty()) {
			System.out.println("WINNER\nArmy 2 is the winner. Remaining troops: ");
			army2.printArmyFull();
			
			System.out.println("\nThe most Outstanding Troop is:");
			System.out.println(army2.getOutstandingTroop().name + ", health=" + army2.getOutstandingTroop().health + ", totalDamage =" + army2.getOutstandingTroop().total_damage);
		}
		else if (army2.isEmpty()) {
			System.out.println("WINNER\nArmy 1 is the winner. Remaining troops: ");
			army1.printArmyFull();
			
			System.out.println("\nThe most Outstanding Troop is:");
			System.out.println(army1.getOutstandingTroop().name + ", health=" + army1.getOutstandingTroop().health + ", totalDamage =" + army1.getOutstandingTroop().total_damage);
		}
		
	}
}
