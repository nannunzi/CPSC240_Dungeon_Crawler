public class Item{
	
	private ItemType type;
        private String name;
        private int weight;
        private int value;
        private int strength;

	public Item(ItemType t, String n, int w, int v, int s){
		this.type=t;
		this.name=n;
		this.weight=w;
		this.value=v;
		this.strength=s;
	}
	public int getWeight(){
		return this.weight;
	}
	public int getValue(){
		return this.value;
	}
	public int getStrength(){
		return this.strength;
	}
	public String getName(){
		return this.name;
	}
	public ItemType getType(){
		return this.type;
	}
	public String toString(){
		return (this.name + ": A "+this.type+" Weight: "+this.weight+" Value: "+this.value+" Strength: "+this.strength+".");
	}
}
