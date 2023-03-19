import exceptions.CustomIllegalArgumentException;
import exceptions.CustomNoSuchElementException;

public class ArrayBinaryTree implements Tree {
    private static final int INIT_SIZE = 10;
    
    private int[] tree;
    private boolean[] hasElement;
    private int size;
    private int capacity;
    
    public ArrayBinaryTree(int root) {
        this.tree = new int[INIT_SIZE];
        this.hasElement = new boolean[INIT_SIZE];
        tree[ROOT] = root;
        hasElement[ROOT] = true;
        this.capacity = INIT_SIZE;
        this.size = 1;
    }
    
    @Override
    public void addChild(int parent, boolean isLeftChild, int value) {
        if (parent == 0) {
            throw new CustomIllegalArgumentException("인덱스 0은 사용하지 않는 인덱스입니다.");
        }
        
        if (isNotExist(parent)) {
            throw new CustomNoSuchElementException("해당하는 부모노드는 존재하지 않습니다.");
        }
        
        int child = 2*parent + (isLeftChild ? 0 : 1);
        if (child >= capacity) {
            increaseCapacity();
        }
        
        tree[child] = value;
        hasElement[child] = true;
        size++;
    }
    
    private void increaseCapacity() {
        int[] increasedTree = new int[capacity*2];
        boolean[] increasedHasElement = new boolean[capacity * 2];
        System.arraycopy(tree, 0, increasedTree, 0, capacity);
        System.arraycopy(hasElement, 0, increasedHasElement, 0, capacity);
        capacity *= 2;
        tree = increasedTree;
        hasElement = increasedHasElement;
    }
    
    @Override
    public void changeRoot(int value) {
        tree[ROOT] = value;
    }
    
    @Override
    public void removeNode(int node) {
        if (isNotExist(node)) {
            throw new CustomNoSuchElementException("해당하는 노드는 존재하지 않습니다.");
        }
    
        removeNodeRecur(node);
    }
    
    private void removeNodeRecur(int node) {
        if (isNotExist(node)) {
            return;
        }
        
        hasElement[node] = false;
        size--;
        removeNodeRecur(node * 2);
        removeNodeRecur(node * 2 + 1);
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void preOrder() {
        preOrderRecur(ROOT);
    }
    
    private void preOrderRecur(int node) {
        if (isNotExist(node)) {
            return;
        }
    
        System.out.printf("%d ", tree[node]);
        preOrderRecur(node*2);
        preOrderRecur(node * 2 + 1);
    }
    
    @Override
    public void inOrder() {
        inOrderRecur(ROOT);
    }
    
    private void inOrderRecur(int node) {
        if (isNotExist(node)) {
            return;
        }
    
        inOrderRecur(node*2);
        System.out.printf("%d ", tree[node]);
        inOrderRecur(node * 2 + 1);
    }
    
    @Override
    public void postOrder() {
        postOrderRecur(ROOT);
    }
    
    private void postOrderRecur(int node) {
        if (isNotExist(node)) {
            return;
        }
    
        postOrderRecur(node*2);
        postOrderRecur(node * 2 + 1);
        System.out.printf("%d ", tree[node]);
    }
    
    private boolean isNotExist(int node) {
        return node >= capacity || !hasElement[node];
    }
}
