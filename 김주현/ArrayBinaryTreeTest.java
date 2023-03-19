/*
*  Level : 0                  1
*                        /         \
*  Level : 1            3           7
*                    /     \          \
*  Level : 2       10      5           9
*                        /   \       /  \
*  Level : 3            2    11     4    6
*                                         \
*  Level : 4                              20
* */

public class ArrayBinaryTreeTest {
    static final boolean LEFT = true;
    static final boolean RIGHT = false;
    
    public static void main(String[] args) {
        // Level : 0
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(1);
        
        // Level : 1
        arrayBinaryTree.addChild(1, LEFT, 3);
        arrayBinaryTree.addChild(1, RIGHT, 7);
        
        // Level : 2
        arrayBinaryTree.addChild(2, LEFT, 10);
        arrayBinaryTree.addChild(2, RIGHT, 5);
        arrayBinaryTree.addChild(3, RIGHT, 9);
        
        // Level : 3
        arrayBinaryTree.addChild(5, LEFT, 2);
        arrayBinaryTree.addChild(5, RIGHT, 11);
        arrayBinaryTree.addChild(7, LEFT, 4);
        arrayBinaryTree.addChild(7, RIGHT, 6);
        
        // Level : 4
        arrayBinaryTree.addChild(15, RIGHT, 20);
        
        // 루트 노드 교체 test
//        arrayBinaryTree.changeRoot(100);
        
        // Remove test
//        arrayBinaryTree.removeNode(7);
//        arrayBinaryTree.addChild(3, RIGHT, 21);
        
        // 없는 부모노드에 자식 추가 test
//        arrayBinaryTree.addChild(6, RIGHT, 12);
        
        // 부모노드로 0을 사용 test
//        arrayBinaryTree.addChild(0, LEFT, 1);
        
        System.out.println("[ PreOrder 순회 ]");
        arrayBinaryTree.preOrder();
        System.out.println("\n");
    
        System.out.println("[ InOrder 순회 ]");
        arrayBinaryTree.inOrder();
        System.out.println("\n");
    
        System.out.println("[ PostOrder 순회 ]");
        arrayBinaryTree.postOrder();
        System.out.println("\n");
    
        System.out.printf("tree size : %d\n", arrayBinaryTree.size());
    }
}
