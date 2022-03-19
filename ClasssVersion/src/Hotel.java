import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Hotel {
    private static Room[] roomobj;
    private static String[] alphabet;
    // private static int[] perNo;

    //private static String[] roomobj;
    //int y = 6; mytest


    public static void initialise(Room[]roomRef) {
        //initialise method
        for (int x = 0; x < 8; x++ ) roomRef[x].setRoomname("e");
        System.out.println( "initialise ");
    }
    public static Room[] addCustomer(Room[] roomobj, Person[] perNo,Queue wait ) throws IOException {
        // add customer  method
        int persons;
        int roomNum;
        int creditcard;
        String roomName;
        String firstname;
        String surname;
        boolean emptyrooms = true;

        Scanner input = new Scanner(System.in);
        for(int i = 0;i<roomobj.length ; i++){
            if (roomobj[i].getRoomname().equals("e")){
                emptyrooms = true;
            }else {
                emptyrooms = false;
            }

        }
        if (emptyrooms){//if there is an empty room then add or else add to waiting circular queue.
            System.out.println("Enter room number (0-8) or q to stop:\n");
            roomNum = input.nextInt();
            System.out.println("Enter name of Customer for room " + roomNum + " :\n");
            roomName = input.next();
            roomobj[roomNum].setRoomname(roomName);

            System.out.println("Enter no of persons for Room  " + roomNum + " :\n");
            persons = input.nextInt();
            perNo[roomNum].setNoOfpersons(persons);

            System.out.println("Enter First name of paying guest for Room:" + roomNum + " :\n");
            firstname = input.next();
            perNo[roomNum].setfistname(firstname);

            System.out.println("Enter Surname of paying guest for Room: " + roomNum + " :\n");
            surname = input.next();
            perNo[roomNum].setSurName(surname);

            System.out.println("Enter Credit card no of paying guest for Room:"+ roomNum +":\n");
            creditcard = input.nextInt();
            perNo[roomNum].setCreditCardno(creditcard);

        }else {

            wait.enQueue();//waiting circular queue.
        }

        return roomobj;
    }
    public static void deleteCustomer(Room[] roomobj,Queue wait){
        //delete customer method.
        int del;
        System.out.println("Enter room number to clear data :" );
        Scanner input = new Scanner(System.in);
        del = input.nextInt();
        if (wait.getFront()==-1){//for que
            roomobj[del].setRoomname("e");

        }else {
            roomobj[del].setRoomname(wait.deQueue());
        }
    }
    // ----------------method to find customers by name  start------------------
    public static void findCustomer(Room[] roomobj){

        System.out.println("Enter a name you want to search for : ");//---- find a person using the name---
        Scanner input = new Scanner(System.in);
        String searchName = input.next();
        for (int i = 0; i < 8; i++) {
            if (Objects.equals(roomobj[i].getRoomname(), searchName)) {
                //System.out.println(searchName + " is found on index " + i +" is occupied by "+ hotel[i]);
                System.out.println(searchName + " is found on ----------> Room number " + i );
                break;
            } else if (i == 8 - 1) {
                System.out.println(searchName + " is not found anywhere..!");
            }
        }

    }
    // ----------------method to find customers by name  end------------------


    // ----------------method to sort names alphabetically   start------------------
    public static void alphabetical(Room[] roomobj) {
        String temp;
        String[] myStrArray = new String[8];
        for (int i = 0; i < 8; i++) {
            myStrArray[i] = roomobj[i].getRoomname();
        }
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
        // another array for strings
        // Arrays.sort(myStrArray);
        for (String tem2:myStrArray) {
            System.out.println(tem2);
        }

    }  // ----------------method to sort names alphabetically  end------------------




    // ----------------method to save data to the  txt file start------------------
    public static void printarray (Room[]roomobj,Person[]perNo) throws FileNotFoundException {

        PrintWriter pr = new PrintWriter("D:\\cw\\task4\\test2\\x.txt");

        for (int i = 0; i < roomobj.length; i++) {
            pr.println("Room " + i + " occupied by:"+roomobj[i].getRoomname());
            pr.println("\t*No of guests are: "+perNo[i].getNoOfpersons());
            pr.println("\t*First name of paying guest:"+perNo[i].getfistname());
            pr.println("\t*Surname of paying guest:"+perNo[i].getSurName());
            pr.println("\t*Credit card no of paying guest:"+perNo[i].getCreditCardno()+"\n");

        }
        System.out.println("the file is sucessfully added.\n");
        pr.close();//closes the print writer

    }
    // ----------------method to save data to the  txt file end------------------


    //-----------------method to read the txtfile start ------------------------.
    public static void viewarray (Room[]roomobj) throws FileNotFoundException {
        File myarrayObj = new File("D:\\cw\\task4\\test2\\x.txt");
        System.out.println("the aded file is .\n");
        Scanner myReader = new Scanner(myarrayObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();//closes the reader
    }
    //-----------------method to read the txtfile end ------------------------.


    //-----------------view rooms method start --------------------
    public static void viewRooms (Room[]roomobj, Person[]perNo){
        // view all rooms rooms method
        for (int x = 0; x < 8; x++) {
            if (roomobj[x].getRoomname().equals("e")) {
                System.out.println("Your room " + x + " is empty");

            } else {
                System.out.println("Room " + x + " occupied by " + roomobj[x].getRoomname());
                System.out.println("\t*No of guests are: " + perNo[x].getNoOfpersons()+" persons");
                System.out.println("\t*First name of paying guest:" + perNo[x].getfistname());
                System.out.println("\t*Surname of paying guest:" + perNo[x].getSurName());
                System.out.println("\t*Credit card no of paying guest:" + perNo[x].getCreditCardno()+"\n");
            }

        }

    }//-----------------view rooms method end --------------------


    // ----------------- view empty rooms start -------
    public static void Emptyrooms (Room[]roomobj){
        // view all empty rooms rooms method
        for (int x = 0; x < 8; x++) {
            if (Objects.equals(roomobj[x].getRoomname(), "e")) {
                System.out.println("Your room " + x + " is empty");

            }
        }
    }// ----------------- view empty rooms end -------
}




