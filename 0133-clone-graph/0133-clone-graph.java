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
    private Node backtrack(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node graph = new Node(node.val);
        map.put(node, graph);
        List<Node> graphNeighbours = new ArrayList<>();
        for (Node neighbour: node.neighbors) {
            neighbour = backtrack(neighbour, map);
            graphNeighbours.add(neighbour);
        }
        graph.neighbors = graphNeighbours;
        return graph;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return backtrack(node, map);
    }
}