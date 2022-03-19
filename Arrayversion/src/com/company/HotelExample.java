package com.company;
import java.io.*;
import java.util.*;
public class HotelExample {
    private static File myObj;

    public static void main(String[] args) throws IOException {

        /* -------------------save file start---------------------  */

        File myObj;
        myObj = new File("D:\\cw\\task1\\task1ex\\y.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");// shows the file status.
        }

        /*------------- save file end --------------------------*/

        String[] hotel = new String[8];//this is an  array called hotel
        initialise(hotel);//parameter hotel
        boolean menuChoice = true;//this is a boolean

        int perno []=new int[8];//array for the nuber of guests
        String fname[]=new String[8];//array for the first name
        String sname[]= new String[8];//array for the surname
        int creditcdno[]= new int[8];//array for the cerditcard number

        Scanner input = new Scanner(System.in);
        //menu
        while (menuChoice) {
            System.out.print("-------------------Hotel Management System----------------\n");
            System.out.print("Enter a to add  Customer : \n");
            System.out.println("Enter e to View empty rooms: ");
            System.out.println("Enter v to View rooms: ");
            System.out.println("Enter q to quit:");
            System.out.println("Enter d to delete:");
            System.out.println("Enter f to find a customer");
            System.out.println("Enter l to view customer in alphabeical order");
            System.out.println("Enter s to print the customer array");
            System.out.println("Enter r to read the txtfile");
            System.out.print("-----------------------------------------------------------\n");
            String choice = input.next();

            switch (choice) {
                //switch case including the letters in menu and the methods.
                case "a":
                    //Enter a to add a customer
                    hotel = addCustomer(hotel,perno,fname,sname,creditcdno);
                    break;
                case "e":
                    //Enter e to read the txtfile.
                    Emptyrooms(hotel);
                    break;
                case "v":
                    //Enter v to veiew all rooms
                    viewRooms(hotel,perno,fname,sname,creditcdno);
                    break;
                case "q":
                    //Enter q to quit the program
                    menuChoice = false;
                    break;
                case "d":
                    //Enter d to delete a customer
                    deleteCustomer(hotel);
                    break;
                case "f":
                    //Enter f to find a customer
                    findCustomer(hotel);
                    break;
                case "l":
                    //Enter l to view customer names in alphabetical order.
                    alphabetical(hotel);
                    break;
                case "s":
                    //Enter s to save the customer array.
                    printarray(hotel,perno,fname,sname,creditcdno);
                    break;
                case "r":
                    //Enter r to read the txtfile.
                    viewarray(hotel);
                    break;
            }//end of switch case

        }

    }

    private static void initialise(String[] hotelRef) {
        //initialise method
        for (int x = 0; x < 8; x++) hotelRef[x] = "e";
        System.out.println("initialise ");
    }

    private static String[] addCustomer(String[] hotel,int[] perno,String []fname ,String [] sname,int[]creditcdno) throws IOException {
        // add customer  method

        int roomNum;
        String roomName;
        int persons;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-8) or q to quit:\n");
        roomNum = input.nextInt();

        System.out.println("Enter name of Customer for room " + roomNum + " :\n");
        roomName = input.next();
        hotel[roomNum] = roomName;

        System.out.println("Enter no of persons for Room " + roomNum + " :\n");
        persons = input.nextInt();
        perno[roomNum]=persons;

        System.out.println("Enter First name of paying guest for Room:" + roomNum + " :\n");
        String firstname = input.next();
        fname[roomNum]=firstname;

        System.out.println("Enter Surname of paying guest for Room: " + roomNum + " :\n");
        String surname = input.next();
        sname[roomNum]=surname;

        System.out.println("Enter Credit card no of paying guest for Room: "+ roomNum +":\n");
        int creditcard = input.nextInt();
        creditcdno[roomNum]=creditcard;

        return hotel;
    }


    private static void viewRooms(String[] hotel,int []perno,String[] fname,String[]sname,int[]creditcdno) {
        // view all rooms rooms method

        for (int x = 0; x < 8; x++) {
            if (hotel[x].equals("e")) {
                System.out.println("Your room " + x + " is empty");

            } else {
                System.out.println("Room " + x + " occupied by " + hotel[x]);
                System.out.println("\t*No of guests are: " + perno[x]+" persons");
                System.out.println("\t*First name of paying guest:" + fname[x]);
                System.out.println("\t*Surname of paying guest:" + sname[x]);
                System.out.println("\t*Credit card no of paying guest:" + creditcdno[x]+"\n");

            }

        }

    }

    private static void deleteCustomer(String[] hotel) {
        //delete customer method.
        int del;
        System.out.println("Enter room number to clear data :");
        Scanner input = new Scanner(System.in);
        del = input.nextInt();
        hotel[del]="e";
    }

    //------------------------------find customer method.start-------------------
    private static void findCustomer(String[] hotel) {

        System.out.println("Enter a name you want to search for : ");//---- find a person using the name---
        Scanner input = new Scanner(System.in);
        String searchName = input.next();
        for (int i = 0; i < 8; i++) {
            if (hotel[i].equals(searchName)) {
                //System.out.println(searchName + " is found on index " + i +" is occupied by "+ hotel[i]);
                System.out.println(searchName + " is found on ----------> Room number " + i);
                break;
            } else if (i == 8 - 1) {
                System.out.println(searchName + " is not found anywhere..!");
            }
        }

    }
    //------------------------------find customer method end-------------------


    // ----------------method to sort names alphabetically   start------------------
    public static void alphabetical(String[] hotel) {
        String temp;
        String[] myStrArray = new String[8];
        for (int i = 0; i < 8; i++) {
            myStrArray[i] = hotel[i];
        }
        //String temp;
        System.out.println("Alphabatically Sorted names...");
        for (int j = 0; j < 8; j++) {
            for (int i = j + 1; i < 8; i++) {
                // comparing strings
                if (myStrArray[i].compareTo(myStrArray[j]) < 0) {
                    temp = myStrArray[j];
                    myStrArray[j] = myStrArray[i];
                    myStrArray[i] = temp;
                }
            }
        }
        for (String tem2:myStrArray) {
            System.out.println(tem2);
        }

    }  // ----------------method to sort names alphabetically   end------------------

    // ----------------method to save data to the  txt file start------------------
    public static void printarray(String[] hotel,int[]perno, String[]fname,String[]sname,int[]creditcdno) throws FileNotFoundException {

        PrintWriter pr = new PrintWriter("D:\\cw\\task1\\task1ex\\y.txt");
        for (int i = 0; i < hotel.length; i++) {
            if (hotel[i].equals("e")) {
                System.out.println("Your room " + i + " is empty");
            }else {
                pr.println("Room " + i + " occupied by " + hotel[i]);
                pr.println("\t*No of guests are: " + perno[i] + " persons");
                pr.println("\t*First name of paying guest:" + fname[i]);
                pr.println("\t*Surname of paying guest:" + sname[i]);
                pr.println("\t*Credit card no of paying guest:" + creditcdno[i] + "\n");

                System.out.println("the file is sucessfully added.\n");
                pr.close();//closes the print writer
            }
      }
    }// ----------------method to save data to the  txt file end------------------


    //-----------------method to read the txtfile start ------------------------.
    public static void viewarray(String[] hotel) throws FileNotFoundException {
        File myarrayObj = new File("D:\\cw\\task1\\task1ex\\y.txt");
        System.out.println("the aded file is .\n");
        Scanner myReader = new Scanner(myarrayObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();//closes the print reader
    }

    //-----------------method to read the txtfile end ------------------------.

// ----------------- view empty rooms start -------
    public static void Emptyrooms(String[] hotel) throws FileNotFoundException {

        for (int x = 0; x < 8; x++) {
            if (hotel[x].equals("e")) {
                System.out.println("Your room " + x + " is empty");
            }

        }
    }// ----------------- view empty rooms start -------
}