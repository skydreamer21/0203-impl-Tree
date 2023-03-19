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

public class BinaryTreeTest {
    static final boolean LEFT = true;
    static final boolean RIGHT = false;
    
    public static void main(String[] args) {
        // 주석으로 테스트할 Tree 선택
        
        // Level : 0
//        ArrayBinaryTree binaryTree = new ArrayBinaryTree(1);
        LinkedListBinaryTree binaryTree = new LinkedListBinaryTree(1);
        
        // Level : 1
        binaryTree.addChild(1, LEFT, 3);
        binaryTree.addChild(1, RIGHT, 7);
        
        // Level : 2
        binaryTree.addChild(2, LEFT, 10);
        binaryTree.addChild(2, RIGHT, 5);
        binaryTree.addChild(3, RIGHT, 9);
        
        // Level : 3
        binaryTree.addChild(5, LEFT, 2);
        binaryTree.addChild(5, RIGHT, 11);
        binaryTree.addChild(7, LEFT, 4);
        binaryTree.addChild(7, RIGHT, 6);
        
        // Level : 4
        binaryTree.addChild(15, RIGHT, 20);
        
        // 루트 노드 교체 test
//        binaryTree.changeRoot(100);
        
        // Remove test
//        binaryTree.removeNode(7);
//        binaryTree.addChild(3, RIGHT, 21);
        
        // 없는 부모노드에 자식 추가 test
//        binaryTree.addChild(6, RIGHT, 12);
        
        // 부모노드로 0을 사용 test
//        binaryTree.addChild(0, LEFT, 1);
        
        System.out.println("[ PreOrder 순회 ]");
        binaryTree.preOrder();
        System.out.println("\n");
    
        System.out.println("[ InOrder 순회 ]");
        binaryTree.inOrder();
        System.out.println("\n");
    
        System.out.println("[ PostOrder 순회 ]");
        binaryTree.postOrder();
        System.out.println("\n");
    
        System.out.printf("tree size : %d\n", binaryTree.size());
    }
}
