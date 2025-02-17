package Trees;

import java.util.*;

import javax.swing.tree.Tree;

class TreeUtilities extends Tree
{


    void inorder(Tree root)
    {
        if(root==null)
        return ;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    int height(Tree root)
    {
        if(root == null)
        return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }


    boolean serach(Tree root, int data)
    {
        if(root == null) return false;

        if(root.data == data) return true;

        if(root.data > data) return serach(root.right, data);

        return serach(root.left, data);
    }

    Tree insert(Tree root, int data)
    {
        if(root == null)
            return new Tree(data);

        if(root.data > data)
             root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);   
        
        return root;
    }

      public Tree deleteNode(Tree root, int key) 
      {
        if(root == null)
            return null;

        if(root.data > key){
            root.left = deleteNode(root.left,key);
        }else if(root.data < key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                Tree cur = getNode(root);
                root.data = cur.data;
                root.right = deleteNode(root.right,cur.data);
            }
        }
        return root;
    }
    
    Tree getNode(Tree root) 
    {
        Tree cur = root.right;

        while (cur.left != null) {
         cur = cur.left;
        }
        
        return cur;
}

}