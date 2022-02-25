package Tree;

import java.util.List;

public class Node {
    public int val;
    public List<Tree.Node> children;

    public Node(){}
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Tree.Node> children) {
        this.val = val;
        this.children = children;
    }
}
