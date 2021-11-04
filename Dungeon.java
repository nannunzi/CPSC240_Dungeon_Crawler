public class Dungeon{
                String input = "w";


        int charPosition = 609;
        int oldCharPosition = 609;
        String playerMarker = "@";

        //Map Key: 
        //@ = player
        //? = Item
        //! = Enemy
        //# = Enemy
        //& = Enemy
        private String map =
                "----------------------------------------------------------------------------------------------------\n"+
                "|                                                                                                  |\n"+
                "|                                                                                             ?    |\n"+
                "|                                              !                                                   |\n"+
                "|                                                                                                  |\n"+
                "|                                                                                                  |\n"+
                "|      @                                                                                           |\n"+
                "|                                                                                                  |\n"+
                "|                                                             !                                    |\n"+
                "|                                                                                                  |\n"+
                "|                                                                                                  |\n"+
                "|                                                                                                  |\n"+
                "------------------------------------------------------------------------------         -------------\n"+
                "-----------------------------------------------------------------------------|         |------------\n"+
                "|                                               |----------------------------|    #    |------------\n"+
                "|                                          ?    |----------------------------|         |------------\n"+
                "|                                               |-----------------------------         -------------\n"+
                "|                      ---------------          |--------|                                         |\n"+
                "|                      |-------------|          |--------|                                    ?    |\n"+
                "|                      |-------------|          |--------|                                         |\n"+
                "|          &           |-------------|          |--------|                                         |\n"+
                "|                      |-------------|          ----------       #                                 |\n"+
                "|                      |-------------|                                                             |\n"+
                "|                      |-------------|     #                                             #         |\n"+
                "|                      |-------------|                                                             |\n"+
                "|                      --------------|          ----------                                         |\n"+
                "|                                |---|          |--------|                                         |\n"+
                "|                                |---|          |--------|                                         |\n"+
                "|                                |---|?         |--------|                                         |\n"+
                "|---------------------------------------------------------------------------------------------------";
        public void Print(){
                System.out.println(map);
        }
        public void  Move(String input){
                if(input == "w"){
                        charPosition -= 100;
                        if((map.substring(0, charPosition) == "-") || (map.substring(0, charPosition) == "|")){
                                charPosition += 100;
                        }else{
                                map = map.substring(0, charPosition) + playerMarker + map.substring(charPosition + 1);
                                map = map.substring(0, oldCharPosition) + " " + map.substring(oldCharPosition + 1);
                                oldCharPosition = charPosition;

                        }

                }
        }
}

