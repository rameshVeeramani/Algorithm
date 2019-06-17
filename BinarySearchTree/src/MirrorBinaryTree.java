public class MirrorBinaryTree {

    public void MirrorTree(Node root) {
        if (root == null)
            return;
        MirrorTree(root.getRHS());
        MirrorTree(root.getRHS());

        Node temp = root.getLHS();
        root.setRHS(root.getLHS());
        root.setLHS(temp);
    }
}
