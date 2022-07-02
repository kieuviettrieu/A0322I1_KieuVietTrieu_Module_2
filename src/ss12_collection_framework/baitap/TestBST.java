package ss12_collection_framework.baitap;


public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(10);
        tree.insert(19);
        tree.insert(14);
        tree.insert(31);
        tree.insert(35);
        tree.insert(42);
        tree.insert(27);

        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("postorder (sorted): ");
        tree.postorder();
        System.out.println("preorder (sorted: ");
        tree.preorder();
        System.out.println("The number of nodes is: " + tree.getSize());

        Integer number=14;
        if(tree.search(number))
        {
            System.out.println(number+" có trong cây!");
        }
        else
        {
            System.out.println(number+" không có trong cây!");
        }

        System.out.println("///////////");
        tree.delete(31);
        tree.inorder();
    }
}
