public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static Node<Integer> Insert(Node<Integer> node, Node<Integer> root) {
        if (root == null)
            return node;

        if (node.getData() < root.getData()) {
            root.setLHS(Insert(node, root.getLHS()));
        } else {
            root.setRHS(Insert(node, root.getRHS()));
        }
        return node;
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



/* insertion

Compare the root to be added
so if its smaller then comare with lhs
so if its smaller again go to the smaller
if its higher then compare with the higher
if the position is open and no need for replacement

but ther might be situation where it has to be replaced.
* */