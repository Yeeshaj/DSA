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
    
}
