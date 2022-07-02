package ss12_collection_framework.thuchanh;

public interface Tree<E> {

    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
