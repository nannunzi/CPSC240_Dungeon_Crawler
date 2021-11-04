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
			System.out.println(map.substring(charPosition));
			if(map.substring(0, charPosition) == "-"||map.substring(0, charPosition) == "|"){
                                throw new IllegalMovmentException();
`
                        }else{
				charPosition-=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;}
		}if(input == "a"){
                        if(map.substring(0, charPosition-1) == "|"||map.substring(0, charPosition) == "-"||){
                                 throw new IllegalMovmentException();
				
                       	}else{
				charPosition-=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
				}
		}if(input == "s"){
                        
                        if(map.substring(0, charPosition+100) == "-"||map.substring(0, charPosition) == "|"){
                                 throw new IllegalMovmentException();	
                        }else{
				charPosition+=100;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;
			}
		}if(input == "d"){
                        if(map.substring(0, charPosition+1) == "|"||map.substring(0, charPosition) == "-"){
				 throw new IllegalMovmentException();
				
                        }else{
				charPosition+=1;
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition +1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;

                        }

                }
        }
}

