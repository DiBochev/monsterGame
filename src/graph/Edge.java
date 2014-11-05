package graph;
public class Edge {
 
    private Node FirstNode, SecondNode;
     
    public Edge(Node FirstNode, Node SecondNode) {
    	setFirstNode(FirstNode);
    	setSecondNode(SecondNode);
    }

	public Node getFirstNode() {
		return FirstNode;
	}

	private void setFirstNode(Node FirstNode) {
		this.FirstNode = FirstNode;
	}

	public Node getSecondNode() {
		return SecondNode;
	}

	private void setSecondNode(Node SecondNode) {
		this.SecondNode = SecondNode;
	}

	

	public boolean equals(Node node1, Node node2) {
		if((FirstNode.equals(node1)) && (SecondNode.equals(node2))){
			return true;
		}if((FirstNode.equals(node2)) && (SecondNode.equals(node1))){
			return true;
		}else{
			return false;
		}
	}

	
	
}