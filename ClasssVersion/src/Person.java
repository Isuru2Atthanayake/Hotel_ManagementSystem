//--number of persons start .------------
public class Person extends Hotel {
    private int noOfpersons;//creating an instance variable for number of persons.
    private String firstName;//instance variable for first name
    private String surName;//instance variable for Surname name
    private int creditCardno;//instance variable for creditcard number.
    public Person() {
    }

    public int getNoOfpersons() //creating a get method to give read access
    {
        return noOfpersons;
    }

    public void setNoOfpersons(int p) { //setmethod to give write access
        noOfpersons = p;
    }
//--number of persons end .------------



//-------first name start.------------

    public String getfistname() //creating a get method to give read access
    {
        return firstName;
    }
    public void setfistname(String n) { //setmethod to give write access
        firstName = n;
    }
//-------- first name end.------------



    //--------------------------- surname start.------------
    public String getSurName() //creating a get method to give read access
    {
        return surName;
    }

    public void setSurName(String s) {//setmethod to give write access
        surName = s;
    }
    // ------------------------ surname end.------------------------------


    //--------------getCreditCardno start-----------------
    public int getCreditCardno()//creating a get method to give read access
    {
        return creditCardno;
    }

    public void setCreditCardno(int c) {
        creditCardno = c;
    }
    //--------------getCreditCardno end------------------

}




   /*
   * private String roomname;//creating an instance variable
    public Room() {
    }
   * */
