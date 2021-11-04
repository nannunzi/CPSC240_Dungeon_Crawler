public class Enemy{

	private int health;
	private int damage;
	private EnemyType type;
	private String name;
	private int position;

	public Enemy(EnemyType t, int h, int d, String n, int p){
		this.health=h;
		this.type=t;
		this.damage=d;
		this.name=n;
		this position = p;
	}
}	
