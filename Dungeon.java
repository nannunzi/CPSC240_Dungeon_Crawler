public class Dungeon{
	//Map Key: 
	//@ = player
	//? = Item
	//! = Enemy
	//# = Enemy
	//& = Enemy
	private static String map = 
		"----------------------------------------------------------------------------------------------------\n"+
		"|                                                                                                  |\n"+
		"|                                                                                             ?    |\n"+
		"|                                              !                                                   |\n"+
		"|                                                                                                  |\n"+
		"|                                                                                                  |\n"+
		"|      @                                                                                           |\n"+
		"|                                                                                                  |\n"+
		"|                                                              !                                    |\n"+
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
}
