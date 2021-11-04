import java.util.Scanner;
public class Main{
        public static void main(String[] args){
        Inventory inventory = new Inventory(100);
        ItemGenerator theGen= new ItemGenerator();
        Scanner in = new Scanner(System.in);
        int choos=0;
        while(choos!=6){
                System.out.println("What would you like to do?");
                System.out.println("-----------------------------");
                System.out.println("1. Print inventory \n2. move\n3. Drop item \n4. Equip Weapon \n5. Equip Armor\n6. Exit");
                choos = in.nextInt();
                switch (choos) {
                        case 1: inventory.print();
                                break;
			//case 2: while(!(choos.equalsIgnoreCase("q"))){

			//}
                         //	break;       
                        case 3: inventory.drop();
                                break;
                        case 4: inventory.equipWeapon();
                                break;
                        case 5: inventory.equipArmor();
                                break;
                        case 6: System.out.println("understood, exiting.");
                                break;
                        default: System.out.println("Invalid command");
                	Dungeon dungeon = new Dungeon();
                	String input = "w";
                	dungeon.Print();
                	dungeon.Move(input);
                	dungeon.Print();
                	dungeon.Move(input);
                	dungeon.Print();
                	dungeon.Move(input);
                	dungeon.Print();
                	dungeon.Move(input);
                	dungeon.Print();
               		 dungeon.Move(input);
               		 dungeon.Print();
               		 dungeon.Move(input);
               		 dungeon.Print();
	       		}

                }
        }
}
           
/*
 * code scrapyard
	public static void main(String[] args){
		Dungeon dungeon = new Dungeon();
		String input = "w";
		dungeon.Print();
		dungeon.Move(input);
		dungeon.Print();
		dungeon.Move(input);
		dungeon.Print();
		dungeon.Move(input);
		dungeon.Print();
		dungeon.Move(input);
		dungeon.Print();
		dungeon.Move(input);
                dungeon.Print();
		dungeon.Move(input);
                dungeon.Print();
	}
	if(inventory.add(theGen.generate()))
                                {
                                 System.out.println("added random item");
                                break;
                                }
                                else{
                                       System.out.println("cannot add item, inventory too full.");
                                        break;
                                }
				*/

