public interface Tree {
    int ROOT = 1;
    
    void addChild(int parent, boolean isLeftChild, int value);
    void changeRoot(int value);
    void removeNode(int node);
    int size();
    void preOrder();
    void inOrder();
    void postOrder();
}
