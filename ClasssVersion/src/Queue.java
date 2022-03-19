import java.util.Scanner;
public class Queue extends Room {
    private int size = 7; // length of Circular Queue for the waiting list .
    private int front, rear;//front- first element of queue and rear - is the last element  last element.
    public String[] items = new String[size];

    //-1 is the innitial position of both front and rear.
    Queue() {
        front = -1; //first element of circular queue
        rear = -1;//last element of circular queue
    }

    public int getFront() {
        return front;
    }

    // this is used to see if the queue is full
    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true; // gets full when front = rear element.
        }
        return false;
    }

    // enQueue to add a element to the queue.
    public void enQueue() {
        if (isFull()) {
            System.out.println("Queue is full");//this shows when the queue is full.

        } else {
            Scanner input = new Scanner(System.in);//scanner class.
            System.out.println("All the rooms are full..! please enter a name to add to waiting list:");
            String Waitname = input.next();//name to withing list

            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] =Waitname;
            System.out.println("Name has been Inserted " );
        }
    }

    // code an element from the queue
    public String deQueue() {
        String element;
        element = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } /* Q has only one element, so we reset the queue after deleting it. */
        else {
            front = (front + 1) % size;//equation to remove an element
        }
        return (element);//return value

    }





}

