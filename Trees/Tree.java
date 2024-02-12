package Trees;
import java.util.*;
public class Tree {
    int data;
    Tree left,right;
    void inorder(Tree root)
    {
        if(root==null)
        return ;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
