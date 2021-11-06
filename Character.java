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

	public void pickup(Item i){
		this.inventory.add(i);
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int h){
		this.health=h;
	}
	public void combat(Enemy e){
		e.setHealth(e.getHealth()-this.getInventory().getEquippedWeapon().getStrength());
		System.out.println("you attack the enemy for " + this.getInventory().getEquippedWeapon().getStrength()+" damage.");
		if (e.getHealth()<=0){
			System.out.println("you have slain the "+e.getName());
		e.die();
		}
		else{
			int dam = e.getDamage();
			dam= dam-this.getInventory().getEquippedArmor().getStrength();
			if (dam>=1)
			{
				System.out.println("the " + e.getName()+ " has attacked you for " + dam+ " damage!");
				this.setHealth(this.getHealth()-dam);
			}
			else
			{
				System.out.println("the enemy cant break through your armor!");
			}
		}

	}

	public String getName()
	{
		return this.name;
	}
	public Inventory getInventory(){
		return this.inventory;
	}
	public int getPosition(){
		return this.position;
	}
	public void move(int l)
	{
		this.position=l;
	}
}
