import java.util.Scanner;
public class Main{
        public static void main(String[] args){
        //The story
	System.out.println("In a cheap spin off of SUPERHOT, where time moves only when you move, there are two enemies that stand in that way of glory! Killing them is easy… catching them is not…");
	Inventory inventory = new Inventory(100);
	Item weapon = new Item (ItemType.Weapon, "Steel Shortsword", 5, 5, 5);
       	inventory.add(weapon);
	inventory.setEqWep(weapon);
	Item arm = new Item (ItemType.Armor, "'Vote 4 Pedro' tee", 1, 10, 1);
	inventory.add(arm);
	inventory.setEqArm(arm);
	Character boio = new Character(inventory, "the great player", 100, 607); 
        Scanner in = new Scanner(System.in);
	Enemy e1= new Enemy(EnemyType.Orc, 100, 10, "Basic Orc", 590);
	Enemy e2= new Enemy(EnemyType.Goblin, 50, 15, "Basic Goblin", 720);	
	Dungeon dungeon = new Dungeon(boio, e1, e2);
	String e1Move;
	String e2Move;

        int choos=0;
        while(choos!=6){
                System.out.println("What would you like to do?");
                System.out.println("-----------------------------");
                System.out.println("1. Print inventory \n2. Move\n3. Drop item \n4. Equip Weapon \n5. Equip Armor\n6. Exit");
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
					e1Move = e1.move();
					e2Move = e2.move();
					dungeon.enemyMove(e1Move, e1);
					dungeon.enemyMove(e2Move, e2);
					}
					  catch(Dungeon.IllegalMovmentException e){
						{
						//	try{
						//	dungeon.Look(input);
						//	}
						//	catch (Dungeon.IllegalMovmentException f){}
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
