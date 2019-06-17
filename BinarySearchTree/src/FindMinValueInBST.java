public class FindMinValueInBST {

    public static Node<Integer> find(Node<Integer> root) {

        if (root == null)
            return null;

        if (root.getLHS() == null)
            return root;

        return find(root.getLHS());
    }
}
