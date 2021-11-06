import java.util.ArrayList;
import java.util.Scanner;
public class Inventory{

	private ArrayList<Item> items;
	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;
	
	public Inventory(int maxWeight){
		this.items=new ArrayList<Item>();
		this.maxWeight=maxWeight;
		this.equippedWeapon = null;
		this.equippedArmor = null;
	}
	public int totalWeight(){
	 int curWeight=0;
                for(Item i : this.items){
                        curWeight+=i.getWeight();
                }
		return curWeight;
	}
	public boolean add(Item item){
		int curWeight=0;
		for(Item i : this.items){
			curWeight+=i.getWeight();
		}
		if((curWeight + (item.getWeight()))>=this.maxWeight){
		return false;
		}
		else{
		this.items.add(item);
		return true;
		}
	}

	public void drop()
	{
		Scanner scan = new Scanner(System.in);
		int count=0;
		System.out.println("Select which one to drop");
                for(Item i : this.items){
			count++;
                       System.out.println(count + ": " + i.toString()); 
                }
		int choice = scan.nextInt()-1;
		items.remove(choice);
		
	}
	public Item getEquippedWeapon(){
		return this.equippedWeapon;
	}
	public Item getEquippedArmor(){
		return this.equippedArmor;
	}
	public void print(){
		System.out.println("your max weight is: " +this.maxWeight+". Your current weight is: " + this.totalWeight());
	int count=0;
	System.out.println("your inventory consists of:");
        for(Item i : this.items){
                        count++;
                       System.out.println(count + ": " + i.toString());
                }
	}


	public void equipWeapon(){
		int count=0;
		Scanner scan = new Scanner(System.in);
                System.out.println("Select which weapon to equip");
                for(Item i : this.items){
                       if(i.getType()==ItemType.Weapon){
			       count++;
                      		 System.out.println(count + ": " + i.toString());
		       }
		}
		        int choice = scan.nextInt()-1;
                 this.equippedWeapon=items.get(choice);
                
                
	}
	public void setEqWep(Item i){
		this.equippedWeapon=i;
	}
	public void setEqArm(Item a){
		this.equippedArmor=a;
	}

        public void equipArmor(){
                int count=0;
		Scanner scan = new Scanner(System.in);
                System.out.println("Select which Armor to equip");
                for(Item i : this.items){
                       if(i.getType()==ItemType.Armor){
			       count++; 
                       System.out.println(count + ": " + i.toString());
                       }
                }
		int choice = scan.nextInt()-1;
                this.equippedArmor=items.get(choice);
                
        }
}
