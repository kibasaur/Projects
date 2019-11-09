/**
 * Class Person - creates people for the game 6.47
 * 
 * A Person is an interactable object that is stored in a room and gives you hints.
 * 
 * @author kibasaur
 * @version 2019.11.07
 */
public class Person
{ 
    private String name;
    private String monologue;
    /**
     * Constructor for objects of class Person
     * 
     * @param name      the name of the person
     * @param monologue what the person says when you interact with it
     */
    public Person(String name, String monologue)
    {   
        this.name = name;    
        this.monologue = monologue;
    }
    /**
     * Method for interaction with the Person
     * @return the person name and what it says
     */
    public String talk()  
    {
        return name + ": " + monologue;
    }
}