package graph;

public class Node {
    
	private int positionX;
	private int positionY;
	protected boolean visited;
     
    public Node(int x, int y) {
        setPositionX(x);
        setPositionY(y);
    }
     
    public boolean isVisited() {
        return visited;
    }
     
    public void visit() {
        visited = true;
    }
     
    public void unvisit() {
        visited = false;
    }

	
    public int getPositionX() {
		return positionX;
	}
    

	private void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	

	public int getPositionY() {
		return positionY;
	}
	

	private void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean equals(Node node) {
		if((node.getPositionX() == getPositionX()) && (node.getPositionY() == getPositionY())){
			return true;
		}else{
			return false;
		}
	}  

	
}