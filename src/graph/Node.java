package graph;

import java.util.ArrayList;

public class Node {
    
	private int positionX;
	private int positionY;
	private boolean visited;
	private ArrayList<Node> childs;
     
    public Node(int x, int y) {
        childs = new ArrayList<Node>();
    	setPositionX(x);
        setPositionY(y);
    }
     
    protected boolean isVisited() {
        return visited;
    }
     
    protected void visit() {
        visited = true;
    }
     
    protected void unvisit() {
        visited = false;
    }

    protected int getPositionX() {
		return positionX;
	}
    
    protected void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
    protected int getPositionY() {
		return positionY;
	}
	
	private void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	protected boolean equals(Node node) {
		if((node.getPositionX() == getPositionX()) && (node.getPositionY() == getPositionY())){
			return true;
		}else{
			return false;
		}
	}  

	protected void addChild(Node node){
		childs.add(node);
	}
}