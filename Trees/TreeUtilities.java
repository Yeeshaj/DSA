package Trees;

import java.util.*;

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
}