public class Dungeon{
	static class IllegalMovmentException extends Exception{} 
	private Enemy[] enemies;
        int charPosition = 607;
        int oldCharPosition = 607;
        String playerMarker = "@";

        //Map Key: 
        //@ = player
        //? = Item
        //! = Enemy
        //# = Enemy
        //& = Enemy
        private String map =
                "---------------------------------------------------------------------------------------------------\n"+
                "|                                                                                                 |\n"+
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
                "|                                               |--------------------------|    #     |------------\n"+
                "|                                          ?    |--------------------------|          |------------\n"+
                "|                                               |---------------------------          -------------\n"+
                "|                      ---------------          |--------|                                        |\n"+
                "|                      |-------------|          |--------|                                   ?    |\n"+
                "|                      |-------------|          |--------|                                        |\n"+
                "|          &           |-------------|          |--------|                                        |\n"+
                "|                      |-------------|          ----------       #                                |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      |-------------|     #                                           #          |\n"+
                "|                      |-------------|                                                            |\n"+
                "|                      --------------|          ----------                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|          |--------|                                        |\n"+
                "|                                |---|?         |--------|                                        |\n"+
                "---------------------------------------------------------------------------------------------------";
        public void Print(){
                System.out.println(map);
        }
        public void  Move(String input) throws IllegalMovmentException{
		System.out.println("above : "+ map.substring(charPosition-100, charPosition-99));
		System.out.println("left : " + map.substring(charPosition-1, charPosition));
		System.out.println("right : " +map.substring(charPosition+1, charPosition+2));
		System.out.println("down : " +map.substring(charPosition+100, charPosition+101));
		if(input.equalsIgnoreCase("w")){
			if(map.substring(charPosition-100, charPosition-99) == "-"){
                                 throw new IllegalMovmentException();
                        }else{
                                charPosition-=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}
		else if(input.equalsIgnoreCase("a")){
                        if(map.substring(charPosition-1, charPosition) == "|"){
                                 throw new IllegalMovmentException();
				
                       	}else{
				charPosition-=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
				}
		}
		else if(input.equalsIgnoreCase("s")){
                        
                        if(map.substring(charPosition+100, charPosition+101) == "-"){
                                 throw new IllegalMovmentException();	
                        }else{
				charPosition+=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}
		else if(input.equalsIgnoreCase("d")){
                       if(map.substring(charPosition, charPosition+1) == "|"){
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
		
        }
}
