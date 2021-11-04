import java.util.Scanner;
public class Main{


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
}
