/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    
    private Node clone(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        // Must put before the child walk.
        map.put(node, copy);
        for (Node child : node.neighbors) {
            copy.neighbors.add(clone(child));
        }
        return copy;
    }
}