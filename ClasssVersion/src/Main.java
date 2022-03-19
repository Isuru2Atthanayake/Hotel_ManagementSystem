import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

class Main {

    private static File myObj;


    public static void main(String[] args) throws IOException {
        Room [] roomobj = new Room[8];// this is an array of room objects to store the room data.
        roomobj[0] = new Room();
        roomobj[1] = new Room();
        roomobj[2] = new Room();
        roomobj[3] = new Room();
        roomobj[4] = new Room();
        roomobj[5] = new Room();
        roomobj[6] = new Room();
        roomobj[7] = new Room();

        Person [] perNo = new Person[8];// this is an array to store the person data.
        perNo[0] = new Person();
        perNo[1] = new Person();
        perNo[2] = new Person();
        perNo[3] = new Person();
        perNo[4] = new Person();
        perNo[5] = new Person();
        perNo[6] = new Person();
        perNo[7] = new Person();

        Queue wait = new Queue();// this is an object for circular queue.



        /* -------------------save file start---------------------  */

        File myObj;
        myObj = new File("D:\\cw\\task4\\test2\\x.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }

        /*------------- save file end --------------------------*/

        Hotel.initialise(roomobj);//parameter roomobj
        boolean menuChoice = true;//this is a boolean


        Scanner input = new Scanner(System.in);//gets the user input.
        //menu
        while (menuChoice) {
            System.out.print("-------------------Hotel Management System----------------\n");
            System.out.print("Enter a to add  Customer :\n ");
            System.out.println("Enter e to view empty rooms:");
            System.out.println("Enter v to View rooms: ");
            System.out.println("Enter q to quit:");
            System.out.println("Enter d to delete:");
            System.out.println("Enter f to find a customer:");
            System.out.println("Enter l to view customer in alphabeical order:");
            System.out.println("Enter s to save the customer array to text:");
            System.out.println("Enter r to read the txtfile:");
            System.out.print("-----------------------------------------------------------\n");
            String choice = input.next();

            switch (choice) {
                //switch case including the letters in menu and the methods.
                case "a":
                    //add a customer
                    roomobj = Hotel.addCustomer(roomobj,perNo,wait);
                    break;
                case "v":
                    //Enter v to veiew all rooms
                    Hotel.viewRooms(roomobj,perNo);
                    break;
                case"e":
                    //Enter e to read the txtfile.
                    Hotel.Emptyrooms(roomobj);
                    break;
                case"q":
                    //Enter q to quit the program
                    menuChoice = false;
                    break;
                case "d":
                    //Enter d to delete a customer
                    Hotel.deleteCustomer(roomobj,wait);
                    break;
                case"f":
                    //Enter f to find a customer
                    Hotel.findCustomer(roomobj);
                    break;
                case"l":
                    //Enter l to view customer names in alphabetical order.
                    Hotel.alphabetical(roomobj);
                    //Hotel.alphabetical(myStrArray);
                    break;
                case"s":
                    //Enter s to print the customer array.
                    Hotel.printarray(roomobj,perNo);
                    break;
                case"r":
                    //Enter r to read the txtfile.
                    Hotel.viewarray(roomobj);
                    break;


            }//end of switch case including the letters in menu and the methods.

        }
    }//end of main

}//end of class



