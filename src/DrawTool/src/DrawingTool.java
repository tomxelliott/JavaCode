import java.awt.Color;
import java.util.LinkedList;
import java.util.*;
import java.io.*;

/**
 * Class DrawingTool - enable a user to draw on a canvas
 * using a 'pen'.
 * The user will start with a canvas and a set of colours to work with.
 * To start drawing on the canvas, the user will need to create a pen, which will in turn be stored in a HashMap.
 * All subsequent pens that are created will also be stored in this HashMap.
 * The user can create, select and delete pens as they wish. All changes will be reflected in the HashMap.
 * If the user deletes all pens that they have created, the program will return to its original state.
 * This means that all commands that the user enters that make use of the pen will return an error message.
 *
 * @author T. Elliott on 2016.11.23
 * @version 1.0 2016.11.23
 */

public class DrawingTool
{
    private Canvas canvas;
    
    private Pen pen;
    private HashMap<String, Pen> pens;
    private Colours colours;
    
    private InputReader reader;

    /**
     * Prepare to draw on a canvas of default size.
     * The program starts with no pens and therefore must be created by the user.
     * The colours have been initialised and are ready to use once a pen is created.
     */
    public DrawingTool()
    {
        this(500, 400);
    }
    
    /**
     * Prepares a canvas with the sizes specified in the parameters.
     * The InputReader is created and the colours are imported from the Colours class.
     * All instances of pen must be created in the draw method.
     * @param width The canvas width.
     * @param height The canvas height.
     */
    public DrawingTool(int width, int height)
    {
        canvas = new Canvas("Drawing Program", width, height);
        reader = new InputReader();
        colours = new Colours();
        colours.addColors();
    }
    
    /**
     * Allow the user to draw on the canvas by typing commands.
     * A HashMap is created that will store all instances of pen. 
     * The command words that affect drawing on the canvas will return an error until a pen is created.
     * The draw() method makes use of a LinkedList to sort through the commands entered by the user.
     * When a pen is created, it starts up at position(0,0) and its colour is black.
     * The method makes use of Switch Statement to appropriately respond to the users input.
     * Any word not that does not have a case in the Switch Statement will return a default error message.
     * To exit the program, the user will simply have to type the word bye once (if they type "bye bye" they will be greeted with an error message).
     */
    public void draw()
    {
        System.out.println("Welcome to the drawing tool.");
        System.out.println("Please create a pen to start drawing.");
        System.out.println("If you need any assistance, type the word help.");
        System.out.println();
        System.out.println("Type bye to exit.");
        
        pens = new HashMap<>();
        boolean finished = false;
        while(!finished) {
            LinkedList<String> command = reader.getInput();
            if(!command.isEmpty()) {
                String firstWord = command.get(0);
                switch(firstWord) {
                    case "bye":
                        if(command.size() > 1) {
                            System.out.println("Error: To exit the program, simply type bye once.");
                            // Error message is printed as we want the user to type only "bye" to exit.
                        }
                        else {
                            // When the keyword "bye" is used, the switch statement will break out of the method and print the Goodbye message.
                            finished = true;
                        }
                        break;
                        
                    case "pen":
                        if(command.size() < 2) {
                            // If the user only enters the word pen but does not specify a name, an error message will be printed.
                            System.out.println("Error: Please enter a valid name for your pen.");
                        }
                        else if(pens.containsKey(command.get(1))) {
                            // If a pen already exists in the HashMap then the below error message will be printed.
                            System.out.println("Error: Pen " + command.get(1) + " already exists. Please try another name.");
                        }
                        else {
                            // A new pen is created. 
                            Pen newPen = new Pen(0, 0, canvas);
                            newPen.setColor(Color.BLACK);
                            newPen.penUp();
                            pens.put(command.get(1), newPen);
                            
                            //A message is printed to inform the user of the location of the new pen and its current state (i.e. up).
                            System.out.println("Pen " + command.get(1) + " position: " + newPen.getX() + "," + newPen.getY());
                            System.out.println("The pen is " + (newPen.isPenDown() ? "down" : "up") + ".");
                            
                            //The new pen is now the active pen and all subsequent commands will apply to this pen.
                            pen = pens.get(command.get(1));
                        }
                        break;
                        
                    case "select":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() < 2) {
                            // The user only enters the word "select" an error message will be printed.
                            System.out.println("Error: Please select a valid pen.");
                        }
                        else if(!pens.containsKey(command.get(1))) {
                            // If the name entered by the user has not been created and is not in the HashMap, an error message will print.
                            System.out.println("Error: That pen does not exist.");
                            System.out.println("Please try another name or try creating a new pen.");
                        }
                        else {
                            // The pen requested by the user now becomes the active pen and all actions are now associated with this pen.
                            pens.get(command.get(1));
                            pen = pens.get(command.get(1));
                        }   
                        break;
                        
                    case "delete":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        
                        else if(command.size() < 2) {
                            // An error message will be printed if only the word "delete" is typed by the user.
                            System.out.println("Error: Please select a valid pen to delete.");
                        }
                        else if(!pens.containsKey(command.get(1))) {
                            // An error message will be printed if the user does not specify a pen that has been created.
                            System.out.println("Error: That pen does not exist. Please try another name.");
                        }
                        else {
                            // The selected pen will be removed from the collection, but can be created again by using the "pen" keyword.
                            pens.remove(command.get(1));
                        }   
                        break;    
                        
                    case "up":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() > 1) {
                            /* If the number of words/numbers entered after "moveto" exceeds the number allowed, 
                            * the user will be notified by the below message.
                            */
                            System.out.println("Error: Invalid Function,");
                            System.out.println("Please try again!");
                        }
                        else {
                            pen.penUp();
                            // The pen is now taken off of the page.
                        }
                        break;
                        
                    case "down":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() > 1) {
                            /* If the number of words/numbers entered after "moveto" exceeds the number allowed, 
                            * the user will be notified by the below message. 
                            */
                            System.out.println("Error: Invalid Function,");
                            System.out.println("Please try again!");
                        }
                        else {
                            pen.penDown();
                            // The pen is now down on the page.
                        }
                        break;   
                        
                    case "move":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() > 2 || command.size() < 2) {
                            /* If the number of words/numbers entered after "move" exceeds the number allowed, 
                            * the user will be notified by the below message.
                            * The same occures if the user enters only the word "move".
                            */
                            System.out.println("Error: This function requires a numerical input."); 
                            System.out.println("Please try again.");
                            System.out.println("Are you sure you didn't mean to use MOVETO?");
                          }
                        else if (!reader.isAnInteger(command.get(1))) {
                            System.out.println("Error: move requires numerical input!");
                          }
                        else {
                              //The pen will move the distance determined by the user.
                              pen.move(Integer.parseInt(command.get(1)));
                        }
                        break;
                        
                    case "moveto": 
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() > 3 || command.size() < 3) {
                            /* If the number of words/numbers entered after "moveto" exceeds the number allowed, 
                            the user will be notified by the below message.*/
                            System.out.println("Error: This function takes two numbers!");
                            System.out.println("Please try again!");
                        }
                        else if (!reader.isAnInteger(command.get(1))) {
                            System.out.println("Error: moveto requires numerical input!");
                        }
                        else if (!reader.isAnInteger(command.get(2)))  {
                            System.out.println("Error: moveto requires numerical input!");
                        }  
                        else {
                            int a = (Integer.parseInt(command.get(1)));
                            int b = (Integer.parseInt(command.get(2)));
                            pen.moveTo(a,b);
                            // The pen will move to the point on the canvas specified by the user.
                        }
                        break;  
                        
                    case "turn":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if (command.size() > 2 || command.size() < 2) {
                            // If the user does not enter a valid request, an error message will be printed.
                            System.out.println("Please enter a valid numerical input.");
                        }
                        else if (!reader.isAnInteger(command.get(1)))  {
                            // An error message will print if the the word following "turn" contains letters and not int value.
                            System.out.println("Error: turn requires numerical input!");
                                }
                        else {
                            pen.turn(Integer.parseInt(command.get(1)));
                        }
                        break;
                        
                    case "turnto":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if (command.size() > 2 || command.size() < 2) {
                           System.out.println("Please enter a valid numerical input.");
                        }
                        else if (!reader.isAnInteger(command.get(1))) {
                            // An error message will print if the the word following "turnto" contains letters and not int value.
                            System.out.println("Error: turnto requires numerical input!");
                        }
                        else {
                            pen.turnTo(Integer.parseInt(command.get(1)));
                        }
                        break;  
                        
                    case "colour":
                        if(pens.size() == 0){
                            // If there have been no pens created by the user and added to the pen HashMap, the error message will be printed.
                            System.out.println("Error: You need to create a pen to use this function!");
                        }
                        else if(command.size() < 2 || command.size() > 2) {
                            // If the input entered by the user is only the word "colour" or uses more than two words, return an error message.
                            System.out.println("Error: Please enter a valid colour!");
                        }
                        else if(colours.colorMap.containsKey(command.get(1))) {
                            Color color = colours.colorMap.get(command.get(1));
                            pen.setColor(color);
                        }
                        else {
                            /*If the colour entered by the user is not one of the ones defined by the program, 
                            a line of text will prompt them.*/
                            System.out.println("Error: Please enter a valid colour!");
                        }
                        break;
                        
                    case "help":
                        System.out.println("Your valid command words are:");
                        System.out.println(getHelpCommands().toLowerCase());
                        //convert all of the Enum command words to lower case to make it easier on the eye.
                        break;  
                        
                    default:
                        System.out.println("Error: Unrecognised command: " + firstWord);
                        break;
                }
            }
        }
        System.out.println("Goodbye.");
    }
    
    /**
     * This method creates a string of the command words that can be called when the command word "help" is entered in the draw too.
     * The main reason for this method is it allows me to convert all the enum commands to lower case. 
     * Thus making it easier on the eye when the "help" command is used.
     * The method makes use of the allOf method from the EnumSet class. 
     * It enables the method loop through the CommandWord enums and add them to the helpString that we will print out once the method is called.
     */
    private String getHelpCommands() 
    {
        String helpWords = new String();
        for (CommandWord help : EnumSet.allOf(CommandWord.class)) {
            //Print out all words from the Enum CommandWord class which contains the help commands for this specific method.
            helpWords += help.toString() + " ";
        }
        return helpWords;
    }
}
