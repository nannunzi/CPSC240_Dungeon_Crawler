import java.util.Random;
public class Enemy{

	private int health;
	private int damage;
	private EnemyType type;
	private String name;
	private int position;
	private static int numdead=0;
	private boolean canMove;

	public Enemy(EnemyType t, int h, int d, String n, int p){
		this.health=h;
		this.type=t;
		this.damage=d;
		this.name=n;
		this.position = p;
		canMove=true;
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int h){
		this.health=h;
	}
	public int getDamage(){
		return this.damage;
	}
	public int getPosition(){
		return this.position;
	}
	public void move(){
		//instantiate random, implement random movement
		if (canMove==true)
		{
			int mov = 0;
		}
	}
	public String getName(){
		return this.name;
	}
	public void die()
	{
		numdead++;
		this.canMove=false;
		System.out.println("you have slain the " +this.type+ ", "+ this.getName()+"!");
		this.position=0;//placeholder, was thinking of putting it in a spot where it can say what weve slain
	}
}	
