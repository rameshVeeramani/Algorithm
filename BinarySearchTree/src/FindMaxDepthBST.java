public class FindMaxDepthBST {

    public int findDepth(Node<Integer> root) {
       if (root == null)
            return 0;
        if (root.getLHS() == null && root.getRHS() == null)
            return 0;
        int leftMaxDepth = 1 + findDepth(root.getLHS());
        int rightMaxDepth = 1 + findDepth(root.getRHS());

        return Math.max(leftMaxDepth, rightMaxDepth);
    }
}
