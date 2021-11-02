public class Character{
	private Inventory inventory;
	private String name;
	private int health;
	private int position;

	public Character(Inventory i, String n, int h, int p)
	{

		this.inventory=i;
		this.name = n;
		this.health= h;
		this.position=p;
	}

}
