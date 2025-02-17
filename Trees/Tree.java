package Trees;

import java.util.*;

public class Tree {

    int data;

    Tree left,right;

    Tree root;

    Tree()
    {
        root = null;
        left = right = null;
    }

    Tree(int data)
    {
        root = new Tree(data);
        root.left = null;
        root.right = null;
    }
    
}
