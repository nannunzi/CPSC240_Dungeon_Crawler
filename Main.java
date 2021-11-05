import java.util.Scanner;
public class Main{
        public static void main(String[] args){
        Inventory inventory = new Inventory(100);
        ItemGenerator theGen= new ItemGenerator();
        Scanner in = new Scanner(System.in);
	Dungeon dungeon = new Dungeon();
        int choos=0;
        while(choos!=6){
                System.out.println("What would you like to do?");
                System.out.println("-----------------------------");
                System.out.println("1. Print inventory \n2. Move\n3.Pick up Item\n4. Drop item \n5. Equip Weapon \n6. Equip Armor\n7. Exit");
                choos = in.nextInt();
                switch (choos) {
                        case 1: inventory.print();
                                break;
			case 2: System.out.println("input q to exit movement mode");
				String input=in.nextLine();
				while(!(input.equalsIgnoreCase("q"))){
					dungeon.Print(); 
					input = in.nextLine();
					try{
                        		dungeon.Move(input);
					}
					  catch(Dungeon.IllegalMovmentException e){
						String dummyItem = "?";
						char item = dummyItem.charAt(0); 
						switch (e){
							case item: ItemGenerator.generate();
								   inventory.add();
								   break;
						
						}	
					  }
                        		  }
                         	break;	
                        case 3: inventory.drop();
                                break;
                        case 4: inventory.equipWeapon();
                                break;
                        case 5: inventory.equipArmor();
                                break;
                        case 6: System.out.println("understood, exiting.");
                                break;
                        default: System.out.println("Invalid command");
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
