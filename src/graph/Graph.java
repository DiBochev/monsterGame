package graph;

import java.util.ArrayList;
 
public class Graph {
 
    private ArrayList<Node> nodes;
    
    public Graph(char[][] map){
    	nodes = new ArrayList<Node>();
    	generateNodes(map);
    	generateChilds();
    }
    
    private void generateChilds(){
    	for (Node node : nodes) {
			Node temp = new Node(node.getPositionX() - 1, node.getPositionY());
			chekAndAdd(node, temp);
			temp = new Node(node.getPositionX() + 1, node.getPositionY());
			chekAndAdd(node, temp);
			temp = new Node(node.getPositionX(), node.getPositionY() - 1);
			chekAndAdd(node, temp);
			temp = new Node(node.getPositionX(), node.getPositionY() + 1);
			chekAndAdd(node, temp);
		}
    }

	private void chekAndAdd(Node node, Node temp) {
		if (IfExistNode(temp)) {
				node.addChild(temp);
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
}