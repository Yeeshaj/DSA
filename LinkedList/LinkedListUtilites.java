package LinkedList;

public class LinkedListUtilites extends Node {

    void addData(int data)
    {
        if(head == null)
        {
            head  = new Node(data);
            return ;
        }

        Node temp  = head;
        while(temp != null)
        {
            if(temp.next == null)
            {
                temp.next = new Node(data);
                return ;
            }
        }
    }

    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    boolean detectLoop()
    {
        Node slow = head , fast = head;
        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;

        }
        return false;
    }
    void addDataAtHead(int data)
    {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }
 
}
