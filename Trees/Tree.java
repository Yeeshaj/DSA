package Trees;

import java.util.*;

public class Tree {

    int data;
    
    Tree left,right;

    Tree()
    {
        left = right = null;
    }

    Tree(int data)
    {
        this.data = data;
        left = right = null;
    }
    
}
