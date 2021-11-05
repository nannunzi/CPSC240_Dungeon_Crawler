public class Dungeon{
	static class IllegalMovmentException extends Exception{} 
	private Enemy[] enemies;
        int charPosition = 607;
        int oldCharPosition = 607;
        String playerMarker = "@";
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
        String key = " ?!";
	char control = key.charAt(0);
	char item = key.charAt(1);
	char enemy = key.charAt(2);
	char test;

	public Dungeon(){

	}
	public void Print(){
                System.out.println(map);
        }
        public void  Move(String input) throws IllegalMovmentException{	
		if(input.equalsIgnoreCase("w")){
			test = map.charAt(charPosition-100);
                        if(test != control){         
				Look(test);
				throw new IllegalMovmentException();	
                        }else{
                                charPosition-=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}
		else if(input.equalsIgnoreCase("a")){
                        test = map.charAt(charPosition-1);
			if(test != control){
                                Look(test);
				throw new IllegalMovmentException();	
                       	}else{
				charPosition-=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
				}
		}
		else if(input.equalsIgnoreCase("s")){
                        test = map.charAt(charPosition + 100);
                        if(test != control){
                                Look(test);
				throw new IllegalMovmentException();
                        }else{
				charPosition+=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}
		else if(input.equalsIgnoreCase("d")){
			test = map.charAt(charPosition + 1);
			if(test != control){
				Look(test);
				throw new IllegalMovmentException();	
                        }else{
				charPosition+=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;

                        }

                }else{
			System.out.println("error");
		}
		
        }public void Look(char test){
		if(test == item){
			ItemGenerator.generate();
			//Main.inventory.add();
		}else if(test == enemy){
			//attack
			
		}
	}
}
