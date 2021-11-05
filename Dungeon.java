public class Dungeon{
	static class IllegalMovmentException extends Exception{} 
	private Enemy enemyA;
	private Enemy enemyB;
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
                "|?                                                                                                |\n"+
                "|                                                                                            ?    |\n"+
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
                "|                                          ?    |--------------------------|          |------------\n"+
                "|                                               |---------------------------          -------------\n"+
                "|                      ---------------          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                   ?    |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          ----------                                        |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      --------------|          ----------                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|?         |--------|                                        |\n"+
                "---------------------------------------------------------------------------------------------------";
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
			newMap+=curChar;

				
        }
		this.map=newMap;
                System.out.println(this.map);
        }
        public void  Move(String input) throws IllegalMovmentException{	
		char test;
		if(input.equalsIgnoreCase("w")){
			test = map.charAt(this.charPosition-100);
                        if(test != control){         
				//Look(test);
				throw new IllegalMovmentException();	
                        }else{
                                this.charPosition-=100;
                                map = map.substring(0, this.charPosition) + playerMarker + map.substring(this.charPosition +1);
                                map = map.substring(0, this.oldCharPosition) + " " + map.substring(this.oldCharPosition + 1);
                                this.oldCharPosition = this.charPosition;
				this.acter.move(this.charPosition);
			}
		}
		else if(input.equalsIgnoreCase("a")){
                        test = map.charAt(charPosition-1);
			if(test != control){
                                //Look(test);
				throw new IllegalMovmentException();	
                       	}else{
				this.charPosition-=1;
                                map = map.substring(0,this.charPosition) + playerMarker + map.substring(this.charPosition +1);
                                map = map.substring(0, this.oldCharPosition) + " " + map.substring(this.oldCharPosition + 1);
                                this.oldCharPosition = this.charPosition;
				this.acter.move(this.charPosition);
				}
		}
		else if(input.equalsIgnoreCase("s")){
                        test = map.charAt(charPosition + 100);
                        if(test != control){
                               // Look(test);
				throw new IllegalMovmentException();
                        }else{
				this.charPosition+=100;
                                map = map.substring(0, this.charPosition) + playerMarker + map.substring(this.charPosition +1);
                                map = map.substring(0, this.oldCharPosition) + " " + map.substring(this.oldCharPosition + 1);
                                this.oldCharPosition = this.charPosition;
				this.acter.move(this.charPosition);
			}
		}
		else if(input.equalsIgnoreCase("d")){
			test = map.charAt(charPosition + 1);
			if(test != control){
				//Look(test);
				throw new IllegalMovmentException();	
                        }else{
				this.charPosition+=1;
                                map = map.substring(0,this.charPosition) + playerMarker + map.substring(this.charPosition +1);
                                map = map.substring(0, this.oldCharPosition) + " " + map.substring(this.oldCharPosition + 1);
                                this.oldCharPosition = this.charPosition;
				this.acter.move(this.charPosition);

                        }


                }else{
			System.out.println("error");
		}
	}
		public void enemyMove(String input, Enemy e) throws IllegalMovmentException{	
                	char test;
			int enPosition=e.getPosition();
			int oldEnPosition=e.getPosition();
			if(input.equalsIgnoreCase("w")){
                        test = map.charAt(enPosition-100);
                        if(test != control){
                                //Look(test);
                                throw new IllegalMovmentException();
                        }else{
                                charPosition-=100;
                                map = map.substring(0, enPosition) + '!' + map.substring(enPosition +1);
                                map = map.substring(0, oldEnPosition) + " " + map.substring(oldEnPosition + 1);
				e.setPosition(enPosition);
                        }
                }
                else if(input.equalsIgnoreCase("a")){
                        test = map.charAt(enPosition-1);
                        if(test != control){
                                //Look(test);
                                throw new IllegalMovmentException();
                        }else{
                                enPosition-=1;
                                map = map.substring(0, enPosition) + '!' + map.substring(enPosition +1);
                                map = map.substring(0, oldEnPosition) + " " + map.substring(oldEnPosition + 1);
                                e.setPosition(enPosition);
                                }
                }
                else if(input.equalsIgnoreCase("s")){
                        test = map.charAt(enPosition + 100);
                        if(test != control){
                               // Look(test);
                                throw new IllegalMovmentException();
                        }else{
                                enPosition+=100;
                                map = map.substring(0, enPosition) + '!' + map.substring(enPosition +1);
                                map = map.substring(0, oldEnPosition) + " " + map.substring(oldEnPosition + 1);
                                e.setPosition(enPosition);
                        }
                }
                else if(input.equalsIgnoreCase("d")){
                        test = map.charAt(enPosition + 1);
                        if(test != control){
                                //Look(test);
                                throw new IllegalMovmentException();
                        }else{
                                enPosition+=1;
                                map = map.substring(0, enPosition) + '!' + map.substring(enPosition +1);
                                map = map.substring(0, oldEnPosition) + " " + map.substring(oldEnPosition + 1);
                                e.setPosition(enPosition);
                        }
                }else{
                }
		
        }public void Look(String eyes)throws IllegalMovmentException{
		char test=' ';
		if(eyes.equalsIgnoreCase("a")){
			test= map.charAt(this.charPosition-1);
		}
		else if(eyes.equalsIgnoreCase("s")){
			test= map.charAt(this.charPosition+100);
		}
		else if(eyes.equalsIgnoreCase("w")){
			test= map.charAt(this.charPosition-100);
		}
		else if (eyes.equalsIgnoreCase("d"))
		{
			test=map.charAt(this.charPosition+1);
		}
		else 
		{
			System.out.println("but theres nothing there");
		}
		if(test == item){

			Item addIt= theGen.generate();
			//need to have a step here where the player can choose to pick it up
			this.acter.pickup(addIt);
		}else if(test == enemy){
			//for later
			//for(Enemy e: this.enemies){	
			//check enemy positions, then see which one to attack
			//}
			if(enemyA.getPosition()==test){
				acter.combat(enemyA);
			}
			else if (enemyB.getPosition()==test)
			{
				acter.combat(enemyB);
			}
			else{
				System.out.println("but theres nobody here");
			}
		}
	}
}
