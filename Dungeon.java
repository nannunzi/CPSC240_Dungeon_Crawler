public class Dungeon{
                String input = "w";
	static class IllegalMovmentException extends Exception{} 

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
		if(input == "w"){
			if(map.substring(charPosition-101, charPosition-100) == "-"){
                                 throw new IllegalMovmentException();
                        }else{
                                charPosition-=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}if(input == "a"){
                        if(map.substring(charposition-2, charPosition-1) == "|"){
                                 throw new IllegalMovmentException();
				
                       	}else{
				charPosition-=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
				}
		}if(input == "s"){
                        
                        if(map.substring(charPosition+99, charPosition+100) == "-"){
                                 throw new IllegalMovmentException();	
                        }else{
				charPosition+=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}if(input == "d"){
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
