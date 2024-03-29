package ss12_collection_framework.baitap;

import ss12_collection_framework.thuchanh.*;
import ss12_collection_framework.thuchanh.AbstractTree;
import ss12_collection_framework.thuchanh.TreeNode;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {

            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    public void preorder()
    {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root)
    {
        if (root == null) return;

        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private void NodeTheMang(TreeNode<E> X, TreeNode<E> Y)
    {
        if (Y.left != null) {
            NodeTheMang(X, Y.left);// tìm ra node trái nhất ?
        } else // tìm ra được node trái nhất rồi nek..
        {
            X.element = Y.element; // cập nhật cái data của node cần xóa chính là data của node thế mạng
            X = Y; // cho node X(là node mà chúng ta sẽ đi xóa sau này) trỏ đến node thế mạng ==> ra khỏi hàm thì ta sẽ xóa node X
            Y = Y.right; // bản chất chỗ này chính là cập nhật lại mối liên kết cho node cha của node thế mạng(mà chúng ta sẽ xóa) với node con của node thế mạng
        }
    }

    public boolean delete(E e)
    {
        return delete(e,root);
    }

    private boolean delete(E e,TreeNode<E > root) {
        if(root==null) return true;
        else
            if(!search(e)) return true;
            else
                if(Integer.parseInt(String.valueOf(e)) < Integer.parseInt(String.valueOf(root.element)))
                {
                    delete(e,root.left);
                }
                else
                    if(Integer.parseInt(String.valueOf(e)) > Integer.parseInt(String.valueOf(root.element)))
                    {
                        delete(e,root.right);
                    }
                    else
                    {
                        TreeNode<E> node=root;
                        if(root.left==null)
                        {
                            root=root.right;
                        }
                        else
                            if(root.right==null)
                            {
                                root=root.left;
                            }
                            else
                            {
                                NodeTheMang(node, root.right);
                            }
                    }
                    return true;
    }

    private E LeftMostValue( TreeNode<E> root )
    {
        while ( root.left != null )
            root = root.left;
        return root.element;
    }

    private void Free(TreeNode<E> root)
    {
        if ( root == null )
            return;

        Free( root.left );
        Free( root.right );
        Free( root );
    }

    public boolean search(E elements) {
        TreeNode<E > current = root;

        while (current != null)
        {
            if (Integer.parseInt(String.valueOf(elements)) < Integer.parseInt(String.valueOf(current.element)))
            {
                current = current.left;
            } else if (Integer.parseInt(String.valueOf(elements)) > Integer.parseInt(String.valueOf(current.element)))
            {
                current = current.right;
            } else
                return true;
        }
        return false;
    }
}
