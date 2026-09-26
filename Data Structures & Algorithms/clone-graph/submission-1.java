/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {

        Map<Node, Node> m = new HashMap<>();
        return dfs(node, m);
    }

    private Node dfs(Node node, Map<Node, Node> m){
        if (node == null) {
            return null;
        }

        if(m.containsKey(node)) return m.get(node);

        Node copy = new Node(node.val);
        m.put(node, copy);

        for(Node curr : node.neighbors){
            copy.neighbors.add(dfs(curr, m));
        }
        return copy;
    }
}