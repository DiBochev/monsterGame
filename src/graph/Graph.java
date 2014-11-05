package graph;

import java.util.ArrayList;
 
public class Graph {
 
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    
    public Graph(char[][] map){
    	nodes = new ArrayList<Node>();
    	edges = new ArrayList<Edge>();
    	generateNodes(map);
    	generateEdges();
    	
    	
    }
    
    private void generateEdges(){
    	for (Node node : nodes) {
			Node temp = new Node(node.getPositionX() - 1, node.getPositionY());
			chekEdgeAndAdd(node, temp);
			temp = new Node(node.getPositionX() + 1, node.getPositionY());
			chekEdgeAndAdd(node, temp);
			temp = new Node(node.getPositionX(), node.getPositionY() - 1);
			chekEdgeAndAdd(node, temp);
			temp = new Node(node.getPositionX(), node.getPositionY() + 1);
			chekEdgeAndAdd(node, temp);
		}
    }

	private void chekEdgeAndAdd(Node node, Node temp) {
		if (IfExistNode(temp)) {
			if(!IfExistEdge(temp, node)){
				addEdge(temp, node);
			}
		}
	}
    
    private void generateNodes(char[][] map){
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == '-'){
					addNode(i, j);
				}
			}
		}
    }
     
    public void unvisitAllNodes() {
        for(int i = 0; i < nodes.size(); i++)
            nodes.get(i).unvisit();
    }
     
    private void addNode(int x, int y) {
        nodes.add(new Node(x, y));
    }
    
    private void addEdge(Node firstNode, Node secondNode){
    	edges.add(new Edge(firstNode, secondNode));
    }
    
    private boolean IfExistNode(Node a){
    	boolean result = false;
    	for (Node node : nodes) {
    		if(node.equals(a)){
				result = true;
				break;
			}
		}
		return result;
	}

    private boolean IfExistEdge(Node a, Node b){
    	boolean result = false;
    	for (Edge edge : edges) {
			if(edge.equals(a, b)){
				result = true;
				break;
			}
		}
    	return result;
    }
}