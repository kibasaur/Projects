import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are munichelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @author  kibasaur
 * @version 2019.11.07
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    private ArrayList<String> medCenter;
    private ArrayList<Person> persons;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    { 
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        medCenter = new ArrayList<>();
        persons = new ArrayList<>();
    }

    /**
     * Define the exits of this room. 
     * The direction is the way to the neihgboring room.
     * 
     * @param direction Direction of movement.
     * @param neighbor  Neighboring Rooms.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    /**
     * Add persons to the room.
     * @param person    the person added.
     */
    public void addPerson(Person person) {
        persons.add(person);
    }
    /**
     * Add a medical center to the room.
     * @param facility  the medical center that is added.
     */
    public void addMedCenter(String facility)
    {
        medCenter.add(facility);
    }
    /**
     * Add items to the room
     * @param item the item added.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    /**
     * Remove items from the room
     * @param item  the item that is being removed.
     */
    public void removeItem(Item item)
    {
        items.remove(item);
    }
    /**
     * Input a direction to access said direction. 
     * 
     * @param direction the direction requested.
     * @return returns the room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    /**
     * Lists available exits from the current location.
     * 
     * @return returns a String of available exits
     */
    public String getExitString()
    {   
        String exitString = ("Travel:");
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            exitString += " " + exit;
        }
        return exitString;
    }
    /**
     * Iterate through the items in the room and list the names
     * 
     * @return returns a String of item names in the ArrayList
     */
    public String getItemString() 
    {
        String itemString = ("");
        for (Item item : items) {
            itemString += item.toString(); 
        }
        return itemString;
    }
    /**
     * Method to get a specific item in the room
     * 
     * @return returns a specified item
     */
    public Item getItem() {
        Item thisItem = null;
        for (Item item : items) {
            thisItem = item;
        }
        return thisItem;
    }
    /**
     * Return a short description of this room, of the form:
     *      in the city to where all roads lead to, Rome
     * 
     * @return A short description of the room
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Return a long description of this room, of the form:
     *      in the city to where all roads lead to, Rome.
     *      Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription() {
        return "\nYou are " + description + "\n\n" + getExitString();
    }
    /**
     * Return a string that describes what item is present in the room
     * 
     * @return A string telling the player if there is an item to interact with
     */
    public String getItemDescription() {
        if (items.size() == 0) {
           return ("");
        } 
        else { 
            return "There is " + getItemString() + ".\nType 'pickup' to take it with you";
        }
    }
    /**
     * Return a string that tells the player if there is a medical center in the room
     * 
     * @return A string telling the player if there is a medical center in the room
     */
    public String getMedCenter() {
        if (medCenter.size() == 0) { 
            return ("");
        } 
        else {
            return "There is a medical research facility in this city... \nMaybe I can come back here and concoct a cure when I've found 7 ingredients...";
        }
    }
    /**
     * Return a String when interacting with a person
     * 
     * @return A String describing what a person says
     */
    public String personTalk()
    {
        String talk = ("");
        for (Person person : persons) {
            talk += person.talk();
        }
        return talk;
    }
    /**
     * Method to check if there is a person in the room
     * 
     * @return A string that tells you if a person is nearby
     */
    public String getPerson() {
        if (persons.size() == 0) {
            return ("");
        }
        else {
            return "There is a person over there ...\nAsk for help!";
        }
    }
    /**
     * Method to check wether a person, an item or a medical center is nearby
     * 
     * @return A string telling you that something is either in the vicinity or not.
     */
    public String getItemInfo() {
        if (items.size() == 0 && medCenter.size() == 0) {
            if (persons.size() > 0) {
            return "I heard someting!\n";
            }
            else {
            return ("");
            }
        } 
        else {
            return "Look around to see if there is anything nearby\n";
        }
    }
}
