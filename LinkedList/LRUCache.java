package LinkedList;

import java.util.*;

public class LRUCache {

    LinkedList<Integer> node;

    HashMap<Integer,Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        node = new LinkedList<>();
        map = new HashMap<>();

        this.capacity = capacity;
    }
    
    public int get(int key) 
    {
        
        if(!map.containsKey(key))
            return -1;

        int index = node.indexOf(key);
        node.remove(index);
        node.addFirst(key);
        
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            int index = node.indexOf(key);
            node.remove(index);
        }    
        else
        {
            if(node.size() >= capacity)
             {
                int lruKey = node.removeLast();
                map.remove(lruKey); 
             } 

        }

        node.addFirst(key);
        map.put(key,value);

        
    }
}
