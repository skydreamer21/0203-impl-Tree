import exceptions.CustomIllegalArgumentException;
import exceptions.CustomNoSuchElementException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LinkedListBinaryTree implements Tree {
    private Node root;
    private int size;
    
    public LinkedListBinaryTree(int root) {
        this.root = new Node(root);
        size = 1;
    }
    
    @Override
    public void addChild(int parent, boolean isLeftChild, int value) {
        if (parent == 0) {
            throw new CustomIllegalArgumentException("인덱스 0은 사용하지 않는 인덱스입니다.");
        }
        
        // findNodeByIndex 메서드 설명 참고
        Node parentNode = findNodeByIndex(parent);
        Node childNode = new Node(value, parentNode);
        if (isLeftChild) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
        size++;
    }
    
    /**
     * 노드의 인덱스로 해당 노드를 찾아 반환합니다. 이때 인덱스란 루트 노드를 1로 했을 때의 인덱스입니다. 만약 인덱스에 해당하는 노드가 존재하지 않는다면 CustomNoSuchElementException가 발생합니다.
     * @param index 노드의 인덱스
     * @return 노드의 인덱스로 해당 노드
     * @throws CustomNoSuchElementException 인덱스에 해당하는 노드가 존재하지 않을 때
     */
    private Node findNodeByIndex(int index) {
        if (index == 1) {
            return root;
        }
        List<Integer> pathToRoot = findPathToRoot(index);
        int pathLength = pathToRoot.size();
        Node node = root;
        int idxFromRoot = 1;
        for (int i = pathLength - 2; i >= 0; i--) {
            int nextIdx = pathToRoot.get(i);
            if (nextIdx == idxFromRoot * 2) {
                node = node.left;
                idxFromRoot = idxFromRoot * 2;
            } else {
                node = node.right;
                idxFromRoot = idxFromRoot * 2 + 1;
            }
    
            if (node == null) {
                throw new CustomNoSuchElementException("해당하는 부모노드는 존재하지 않습니다.");
            }
        }
        return node;
    }
    
    private List<Integer> findPathToRoot(int index) {
        List<Integer> pathToRoot = new ArrayList<>();
        while (index > 0) {
            pathToRoot.add(index);
            index /= 2;
        }
        return pathToRoot;
    }
    
    @Override
    public void changeRoot(int value) {
        Node newRoot = new Node(value);
        newRoot.left = root.left;
        newRoot.right = root.right;
        root = newRoot;
    }
    
    @Override
    public void removeNode(int nodeIndex) {
        Node node = findNodeByIndex(nodeIndex);
        if (node.parent.left == node) {
            node.parent.left = null;
        } else {
            node.parent.right = null;
        }
        size -= findTreeSize(node);
    }
    
    private int findTreeSize(Node node) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        int cnt = 1;
    
        while (!q.isEmpty()) {
            Node now = q.poll();
        
            for (int i=0; i<2; i++) {
                Node next = i == 0 ? now.left : now.right;
                if (next == null) {
                    continue;
                }
            
                cnt++;
                q.add(next);
            }
        }
        return cnt;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void preOrder() {
        preOrderRecur(root);
    }
    
    private void preOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.value);
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }
    
    @Override
    public void inOrder() {
        inOrderRecur(root);
    }
    
    private void inOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.printf("%d ", node.value);
        inOrderRecur(node.right);
    }
    
    @Override
    public void postOrder() {
        postOrderRecur(root);
    }
    
    private void postOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.printf("%d ", node.value);
    }
    
    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;
    
        public Node(int value) {
            this.value = value;
            parent = null;
            left = null;
            right = null;
        }
    
        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            left = null;
            right = null;
        }
    }
}
