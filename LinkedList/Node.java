package LinkedList;

public class Node {
    
    int data;

    Node next;

    Node head = null;

    Node()
    {
        next = null;
    }   

    Node(int data)
    {
        this.data = data;
        next = null;
    }

}
