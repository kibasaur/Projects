/**
 * Class Item - creates an item for the game
 * 
 * An item can be picked up and they are ingredients needed to find the cure to win the game.
 * 
 * @author kibasaur
 * @version 2019.11.07
 */
public class Item
{    
    private String name;
    private String description;
    private int amount; 
    /**
     * Constructor for objects of class Item
     * 
     * @param name  the name of the item
     * @param description a short description of the item
     * @param amount the amount of the given item
     */
    public Item(String name, String description, int amount)
    {   
        this.name = name;    
        this.description = description;
        this.amount = amount;
    }

    /**
     * Method to get a String of the description of the item
     * 
     * @return returns a short description of the item
     */
    public String getItemDescription() {
        return description;
    }
    /**
     * Method to get a String of the name of the item
     * 
     * @return returns the name of the item
     */
    public String toString() {
        return name;
    }
}