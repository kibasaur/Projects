import java.util.ArrayList;
import java.util.HashMap;
/**
 *  This class is the main class of the "World of Zuul" application.
 *  "World of Zuul" is a very simple, text based adventure game.  Users
 *  can walk around some scenery. That's all. It should really be extended
 *  to make it more interesting!
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author  Michael Kölling and David J. Barnes
 * @author kibasaur
 * @version 2019.11.07
 */

public class Game
{   
    /**
     * 
     * Main method to run the game
     */
  public static void main(String[] args) {
    new Game().play();
  }
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> player;
    private int counter;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
        player = new ArrayList<>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room berlin, northFerry, london, glasgow, lochNess, isleOfMan, belfast, dublin, scotFerry, irishFerry, northEastFerry, westFerry, sthlm, oslo, helsinki, warsaw, prague, vienna, munich, zurich, amsterdam, brussels, paris, nantes, toulouse, monaco, southFerry, milan, rome, sicily, barcelona, madrid, lisbon, gibraltar;

        // create the rooms
        berlin = new Room("in Berlin... Some might call it the heart of Europe");
        northFerry = new Room("about to take the ferry between Germany, Sweden and England");
        london = new Room("in London where you might want to stay for a cup of tea or some fish'n'chips");
        glasgow = new Room("in Glasgow... Don't stay here for too long, or you'll be stripped off your trousers and walk out of here in one o'them 'man-skirts'");
        lochNess = new Room("at the mystical lake that is said to the Loch Ness monster");
        isleOfMan= new Room("on the Isle of man. Watch out for goblins lurking around.");
        belfast = new Room("in Belfast. They say the pubs are better here than those in Dublin");
        dublin = new Room("in Dublin. They say the pubs are better here than those in Belfast");
        scotFerry = new Room("about to take the ferry that goes between Scotland, Norhern Ireland and the Isle of Man");
        irishFerry = new Room("about to take the ferry that goes between England, Ireland and the Isle of Man");
        northEastFerry = new Room("about to take the ferry that goes between Sweden, Finland and Poland");
        westFerry = new Room("about to take the ferry between England and France");
        sthlm = new Room("in Stockholm, the capital of Sweden and the biggest city in Scandinavia");
        oslo = new Room("in Oslo. Let's not talk about Oslo");
        helsinki = new Room("in Helsinki where people claim that their vodka is better than the vodka made in Russia");
        warsaw = new Room("in Warsaw where everything seems sooo cheap");
        prague = new Room("in Prague, have some rest. There is cheap beer and the nightlife is said to be pretty good");
        vienna = new Room("in Vienna. I wonder why the Spanish Riding School is located here and not in Spain?");
        munich = new Room("at the borders of Munich. There is a sign that says: 'The city of Munich is only open to outsiders during Oktoberfest RAUS!'");
        zurich = new Room("in Zurich. There sure are a lot of banks here");
        amsterdam = new Room("welcome to Amsterdam the modern day Sodom and Gomorrah!");
        brussels = new Room("in Brussels, everyone seems so serious here... At least there is good chocolate");
        paris = new Room("in Paris. Grab a croissant and check out the Eiffel Tower");
        nantes = new Room("in Nantes, home of the old Gauls that Asterix and Obelix are based on");
        toulouse = new Room("in Toulouse which is known for its rich culinary culture");
        monaco = new Room("in Monaco. Make sure to swing by the harbor and you'll get to see some expensive boats");
        southFerry = new Room("about to take the Mediterranean ferry between Rome, Sicily and Barcelona");
        milan = new Room("in Milan, home to some of the greatest fashion designers");
        rome = new Room("in the city to where all roads lead to, Rome");
        sicily = new Room("in Sicily. If you're not too careful some mobster might rob you");
        barcelona = new Room("in Barcelona where the spoken language isn't spanish or catalan, it's football");
        madrid = new Room("in Madrid. Did you know the oldest restaurant in the world is located here?");
        lisbon = new Room("in Lisbon, which was home to Christopher Columbus for many years");
        gibraltar = new Room("in Gibraltar. Hold onto your purse or a monkey might snatch it");


        // initialise room exits
        berlin.setExit("north", northFerry);
        berlin.setExit("east", warsaw);
        berlin.setExit("south", munich);
        berlin.setExit("west", amsterdam);
        northFerry.setExit("north", sthlm);
        northFerry.setExit("south", berlin);
        northFerry.setExit("west", london);
        london.setExit("north", glasgow);
        london.setExit("east", northFerry);
        london.setExit("south", westFerry);
        london.setExit("west", irishFerry);
        glasgow.setExit("north", lochNess);
        glasgow.setExit("south", london);
        glasgow.setExit("west", scotFerry);
        lochNess.setExit("south", glasgow);
        isleOfMan.setExit("north", scotFerry);
        isleOfMan.setExit("south", irishFerry);
        belfast.setExit("east", scotFerry);
        belfast.setExit("south", dublin);
        dublin.setExit("north", belfast);
        dublin.setExit("east", irishFerry);
        scotFerry.setExit("east", glasgow);
        scotFerry.setExit("south", isleOfMan);
        scotFerry.setExit("west", belfast);
        irishFerry.setExit("north", isleOfMan);
        irishFerry.setExit("east", london);
        irishFerry.setExit("west", dublin);
        northEastFerry.setExit("east", helsinki);
        northEastFerry.setExit("south", warsaw);
        northEastFerry.setExit("west", sthlm);
        westFerry.setExit("north", london);
        westFerry.setExit("south", paris);
        sthlm.setExit("east", northEastFerry);
        sthlm.setExit("south", northFerry);
        sthlm.setExit("west", oslo);
        oslo.setExit("east", sthlm);
        helsinki.setExit("west", northEastFerry);
        warsaw.setExit("north", northEastFerry);
        warsaw.setExit("south", prague);
        warsaw.setExit("west", berlin);
        prague.setExit("north", warsaw);
        prague.setExit("south", vienna);
        prague.setExit("west", munich);
        vienna.setExit("north", prague);
        vienna.setExit("west", zurich);
        munich.setExit("north", berlin);
        munich.setExit("east", prague);
        munich.setExit("south", zurich);
        munich.setExit("west", paris);
        zurich.setExit("north", munich);
        zurich.setExit("east", vienna);
        zurich.setExit("south", milan);
        amsterdam.setExit("east", berlin);
        amsterdam.setExit("south", brussels);
        brussels.setExit("north", amsterdam);
        brussels.setExit("southwest", paris);
        paris.setExit("north", westFerry);
        paris.setExit("northeast", brussels);
        paris.setExit("east", munich);
        paris.setExit("south", toulouse);
        paris.setExit("west", nantes);
        nantes.setExit("east", paris);
        toulouse.setExit("north", paris);
        toulouse.setExit("east", monaco);
        toulouse.setExit("south", barcelona);
        monaco.setExit("east", milan);
        monaco.setExit("south", southFerry);
        monaco.setExit("west", toulouse);
        southFerry.setExit("north", monaco);
        southFerry.setExit("east", rome);
        southFerry.setExit("south", sicily);
        southFerry.setExit("west", barcelona);
        milan.setExit("north", zurich);
        milan.setExit("south", rome);
        milan.setExit("west", monaco);
        rome.setExit("north", milan);
        rome.setExit("west", southFerry);
        sicily.setExit("north", southFerry);
        barcelona.setExit("north", toulouse);
        barcelona.setExit("east", southFerry);
        barcelona.setExit("west", madrid);
        madrid.setExit("east", barcelona);
        madrid.setExit("south", gibraltar);
        madrid.setExit("west", lisbon);
        lisbon.setExit("east", madrid);
        gibraltar.setExit("north", madrid);


        currentRoom = berlin;  // start game berlin
        
        // Add items to rooms
        munich.addItem(new Item("a Beer", "Some leftover beer", 1));
        lochNess.addItem(new Item("a Monster Heart", "An enourmous heart", 1));
        isleOfMan.addItem(new Item("some Fairy Dust", "Mythical dust", 1));
        sicily.addItem(new Item("some Gunpowder", "Is used to fire old guns", 1));
        gibraltar.addItem(new Item("some Monkey Hair", "some hair from a monkey ", 1));
        helsinki.addItem(new Item("an Iceblock", "A block of ice", 1));
        warsaw.addItem(new Item("a Christmas Tree", "An affordable christmas tree", 1));
        rome.addItem(new Item("some Ravioli", "So delicious", 1));
        monaco.addItem(new Item("some Money", "A lot of cash", 1));
        nantes.addItem(new Item("a Gaellic Helmet", "A banged up ancient helmet", 1));

        // Medical Centers that can research cures
        vienna.addMedCenter(new String("East Research"));
        brussels.addMedCenter(new String("Central Research"));
        madrid.addMedCenter(new String("Mediterranean Research"));

        // Added people that gives you hints
        sthlm.addPerson(new Person("Sven", "Nothing makes me feel better than some good old Italian Ravioli!"));
        dublin.addPerson(new Person("Chav", "Even the beer in Munich is better than the shit beer in Belfast!"));
        belfast.addPerson(new Person("Chad", "Even the beer in Munich is better than the shit beer in Dublin!"));
        london.addPerson(new Person("Courtney", "Those mobsters in the Mediterranean are crazy!"));
        paris.addPerson(new Person("Céline", "I have been to Loch Ness several times but I've never seen the monster..."));
        lisbon.addPerson(new Person("Maria", "I really miss the nordic winter..."));
        amsterdam.addPerson(new Person("Greta", "I really love Angel Dust, but the stuff they have in the UK is sooooo much better!"));
        zurich.addPerson(new Person("Pièrre", "I went on a trip to Monaco last week.\nHaven't seen my wallet since..."));
        prague.addPerson(new Person("Piotr", "Did you know Asterix and Obelix were from west France?"));
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("pickup")){
            pickup();
        }
        else if (commandWord.equals("sleep")) {
            sleep();
        }
        else if (commandWord.equals("inventory")) {
            inventory();
        }
        else if (commandWord.equals("interact")) {
            interact();
        }
        else if (commandWord.equals("pocketwatch")) {
            watch();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }
    /**
     *  6.41 Timer for the game.
     */
    private void timeUp()
    {   
        counter += 1;
        if (counter > 40) {
            System.out.println("It's too late! \nYou did not manage to find a cure! \nAll of humanity turned into Cronenbergs... \n");
            System.out.println("Thank you for playing.  Good bye.");
            System.exit(0);
        }
    }
    /**
     * Checks the win condition for the game and prints out a statement if it is met and then exits the game.
     */
    private void winCondition()
    {
        if (player.size() >= 7 && currentRoom.getDescription() == "in Vienna. I wonder why the Spanish Riding School is located here and not in Spain?") {
            System.out.println("***************************************************************************************");
            System.out.println("These were the ingredients we needed to make the antidote!");
            System.out.println("The Eastern Research Center in Vienna thanks you dear Vagabond for saving the world!");
            System.out.println("***************************************************************************************");
            System.exit(0);
        }
        else if (player.size() >= 7 && currentRoom.getDescription() == "in Brussels, everyone seems so serious here... At least there is good chocolate") {
            System.out.println("***************************************************************************************");
            System.out.println("These were the ingredients we needed to make the antidote!");
            System.out.println("The Central Research Center in Brussels thanks you dear Vagabond for saving the world!");
            System.out.println("***************************************************************************************");
            System.exit(0);
        }
        else if (player.size() >= 7 && currentRoom.getDescription() == "in Madrid. Did you know the oldest restaurant in the world is located here?") {
            System.out.println("*******************************************************************************************");
            System.out.println("These were the ingredients we needed to make the antidote!");
            System.out.println("The Mediterranean Research Center in Madrid thanks you dear Vagabond for saving the world!");
            System.out.println("*******************************************************************************************");
            System.exit(0);
        }
    }
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("The disease is spreading...");
        System.out.println("It countless lives have already been lost..");
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("looking for a cure.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommandList());
    }

    /**
     * Try to go in one "east"directionglasgow If there is an exit, enter
     * Try to go in one direction. If there is "south" exit, enter
     * Try to go in one direction. If there "west"an belfast, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("You can't go that way!");
        }
        else {
            currentRoom = nextRoom;
            winCondition();
            timeUp();
            printLocationInfo();
        }
    }

    /** 
     * Prints your currentlocation
     */
    private void printLocationInfo() 
    {
        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getItemInfo());
        
    }
    /**
     * Look around the room
     */
    private void look() 
    {
        System.out.println(currentRoom.getLongDescription());  
        System.out.println(currentRoom.getItemDescription());    
        System.out.println(currentRoom.getMedCenter());  
        System.out.println(currentRoom.getPerson());  
    }
    /**
     * Interact with a Person
     */
    private void interact()
    {
        System.out.println(currentRoom.personTalk()); 
    }
    /**
     * Get some rest
     */
    private void sleep()
    {
        System.out.println();
        System.out.println("It's getting late...");
        System.out.println("Maybe I should get some rest.");
        System.out.println("...");
        System.out.println("Zzz");
        System.out.println("...");
        System.out.println("Good morning world!");
        System.out.println();
    }
    /**
     * Pick up an item
     */
    private void pickup()
    {
        Item pickup = currentRoom.getItem();
        player.add(pickup);
        System.out.println();
        System.out.println("You picked up " + pickup + "!\n");
        currentRoom.removeItem(pickup); 
        System.out.println(currentRoom.getLongDescription());
    }
    /**
     * Check inventory
     */
    private void inventory()
    {   
        if (player.size() <= 0) {
            System.out.println("There is nothing in your inventory!");
        }
        String inventory = (""); 
        for (Item item : player) {
            inventory += (item.toString() + ": " + item.getItemDescription() +".\n");
        }
        System.out.println(inventory);
    }
    /**
     * Check how much time is left of the game
     */
    private void watch()
    {
        int timeLeft = 40 - counter;
        System.out.println("You have " + timeLeft + " remaining moves until it's too late!");
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
