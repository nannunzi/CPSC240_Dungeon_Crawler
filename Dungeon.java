import java.util.Scanner;
public class Dungeon{
	static class IllegalMovmentException extends Exception{} 
	private Enemy enemyA;
	private Enemy enemyB;
	Scanner scnr = new Scanner(System.in);
	private static ItemGenerator theGen= new ItemGenerator();
	private Character acter;
	private Item item1;
	private Item item2;
       	private  int charPosition; //= 607;
        private int oldCharPosition; //= 607;
	private int i1Pos;
	private int i2Pos;
	private boolean pick1;
	private boolean pick2;
        static char playerMarker = '@';
	//Map Key
        //@ = player
        //? = Item
        //! = Enemy
        private String map =
                "---------------------------------------------------------------------------------------------------\n"+
                "|                                                                                                 |\n"+
                "|                                                                                                 |\n"+
                "|                                            !                                                    |\n"+
                "|                                                                                                 |\n"+
                "|                                                                                                 |\n"+
                "|      @                                                                                          |\n"+
                "|                                                                                                 |\n"+
                "|                                                           !                                     |\n"+
                "|                                                                                                 |\n"+
                "|                                                                                                 |\n"+
                "|                                                                                                 |\n"+
                "----------------------------------------------------------------------------          -------------\n"+
                "---------------------------------------------------------------------------|          |------------\n"+
                "|                                               |--------------------------|          |------------\n"+
                "|                                               |--------------------------|          |------------\n"+
                "|                                               |---------------------------          -------------\n"+
                "|                      ---------------          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          ----------                                        |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      --------------|          ----------                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "---------------------------------------------------------------------------------------------------\n"+
		"                                                                                                   ";
        static String key = " ?!";
	static char control = key.charAt(0);
	static char item = key.charAt(1);
	static char enemy = key.charAt(2);
	
	

	public Dungeon(Character c, Enemy e, Enemy b){
		this.acter=c;
		this.charPosition=acter.getPosition();
		this.enemyA=e;
		this.enemyB=b;
		this.map=map;
		this.item1= theGen.generate();
		this.item2= theGen.generate();
		this.i1Pos= 1980;
		this.i2Pos= 406;
	 	this.pick1=false;
		this.pick2=false;
	}

	public void Print()
	{
		String newMap="";
		 for (int i = 0; i < this.map.length(); i++) {
 			char curChar= this.map.charAt(i);
			if (i==this.acter.getPosition()){
				curChar=playerMarker;
			}
			else if (i==this.enemyA.getPosition())
			{
				curChar=enemy;
			}
			else if (i==this.i2Pos){
				if(!(this.pick2)){
				 curChar=item;
				}
			}
			else if(i==this.i1Pos){
				if(!(this.pick1)){
				 curChar=item;
				}
			}
			else if (i==this.enemyB.getPosition()){
				curChar=enemy;
			}
			else if(this.map.charAt(i) == playerMarker && i != this.acter.getPosition()){
				curChar = control;
			}
			else if(this.map.charAt(i) == enemy && i != this.enemyA.getPosition()){
                                curChar = control;
                        }
			else if(this.map.charAt(i) == enemy && i != this.enemyB.getPosition()){
                                curChar = control;
                        }
			else if(this.map.charAt(i) == item && (this.pick1 == true || this.pick2 == true)){
                                curChar = control;	
			}
			newMap+=curChar;

				
        }
		this.map=newMap;
                System.out.println(this.map);
        }
        public void  Move(String input) throws IllegalMovmentException{	
		char test;
		int tint;
		if(input.equalsIgnoreCase("w")){
			tint=(this.charPosition-100);
			test = map.charAt(this.charPosition-100);
                        if(test != control){         
				Look(test,tint);
				throw new IllegalMovmentException();	
                        }else{
                                this.charPosition-=100;
				this.acter.move(this.charPosition);
			}
		}
		else if(input.equalsIgnoreCase("a")){
			tint=(this.charPosition-1);
                        test = map.charAt(this.charPosition-1);
			if(test != control){
                                Look(test,tint);
				throw new IllegalMovmentException();	
                       	}else{
				this.charPosition-=1;
				this.acter.move(this.charPosition);
				}
		}
		else if(input.equalsIgnoreCase("s")){
			tint=(this.charPosition+100);
                        test = map.charAt(this.charPosition + 100);
                        if(test != control){
                               	Look(test,tint);
				throw new IllegalMovmentException();
                        }else{
				this.charPosition+=100;
				this.acter.move(this.charPosition);
			}
		}
		else if(input.equalsIgnoreCase("d")){
			tint = (this.charPosition+1);
			test = map.charAt(this.charPosition + 1);
			if(test != control){
				Look(test,tint);
				throw new IllegalMovmentException();	
                        }else{
				this.charPosition+=1;
				this.acter.move(this.charPosition);

                        }


                }else{
		}
	}
		public void enemyMove(String input, Enemy e) throws IllegalMovmentException{	
                	char test;
			int enPosition=e.getPosition();
			int oldEnPosition=e.getPosition();
			if(input.equalsIgnoreCase("w")){
                        test = map.charAt(enPosition-100);
                        if(test != control){
                                throw new IllegalMovmentException();
                        }else{
                                enPosition-=100;
				e.setPosition(enPosition);
                        }
                }
                else if(input.equalsIgnoreCase("a")){
                        test = map.charAt(enPosition-1);
                        if(test != control){
                                throw new IllegalMovmentException();
                        }else{
                                enPosition-=1;
                                e.setPosition(enPosition);
                                }
                }
                else if(input.equalsIgnoreCase("s")){
                        test = map.charAt(enPosition + 100);
                        if(test != control){
                                throw new IllegalMovmentException();
                        }else{
                                enPosition+=100;
                                e.setPosition(enPosition);
                        }
                }
                else if(input.equalsIgnoreCase("d")){
                        test = map.charAt(enPosition + 1);
                        if(test != control){
                                
                                throw new IllegalMovmentException();
                        }else{
                                enPosition+=1;
                                e.setPosition(enPosition);
                        }
                }else{
                }
		
        }public void Look(char test, int tint)throws IllegalMovmentException{
		if(test == item){
			Item addIt= null;
			if(this.i1Pos==tint)
			{
				addIt=this.item1;
			}
			else if (this.i2Pos==tint){
				addIt=this.item2;
			}
			else{
				addIt=theGen.generate();
			}
			System.out.println("you found a " + addIt.getName() + "! Do you want to pick it up? y/n");
			String pickup = scnr.nextLine();
			if(pickup.equalsIgnoreCase("y")){
				this.acter.pickup(addIt);
				System.out.println("You picked up the " + addIt.getName() +"!");
				if(addIt==item1){
				this.pick1=true;
<<<<<<< HEAD
				this.i1Pos = 2900;
				}
				else if (addIt==item2){
				this.pick2=true;
				this.i2Pos = 2901;
=======
				}
				else if (addIt==item2){
				this.pick2=true;
>>>>>>> 3ec7eeefd0c08b8e362ae78f16b6ef1b1f3f0f45
				}
				else{
					System.out.println("you got this item for free");
				}

			}
			else if(pickup.equalsIgnoreCase("n")){
			System.out.println("You did not pick up the " +  addIt.getName() +".");
			}
			else{
				System.out.println("Error, try again");
				Look(test,tint);
			}

		}else if(test == enemy){
			//for later
			//for(Enemy e: this.enemies){	
			//check enemy positions, then see which one to attack
			
			if(enemyA.getPosition()==tint){
				acter.combat(enemyA);
			}
			else if (enemyB.getPosition()==tint){
				acter.combat(enemyB);
			}
			else{
				System.out.println("but theres nobody here");
			}
		}
		
	}
}
