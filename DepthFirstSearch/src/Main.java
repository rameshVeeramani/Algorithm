import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

       //CreateTree
    }

    //public static void CreateTree
}

class DFSpreorder{

    public void preorder(Node<Character> root) {
        if (root == null)
            return;
        Process(root);
        preorder(root.getLHS());
        preorder(root.getRHS());
    }

    void Process(Node root) {
        System.out.println(root);
    }
}
class DFSinorder {

    public void preorder(Node<Character> root) {
        if (root == null)
            return;
        preorder(root.getLHS());
        Process(root);
        preorder(root.getRHS());
    }

    void Process(Node root) {
        System.out.println(root);
    }
}
class DFSpostorder {

    public void preorder(Node<Character> root) {
        if (root == null)
            return;
        preorder(root.getLHS());
        preorder(root.getRHS());
        Process(root);
    }

    void Process(Node root) {
        System.out.println(root);
    }
}

class Node<T> {
2
    private T data;
    private Node<T> lhs;
    private Node<T> rhs;

    public Node(T d) {
        data = d;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getRHS() {
        return this.rhs;

    }

    public Node<T> getLHS() {
        return this.lhs;
    }

    public void setRHS(Node rhs) {
        this.rhs = rhs;

    }

    public void setLHS(Node lhs) {
        this.lhs = lhs;
    }
}
