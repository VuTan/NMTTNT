package Lab1;
import java.util.ArrayList;
import java.util.List;

public class Node {
	int state;
	boolean visited;
	List<Node> neighbours;
	Node parent;

	public Node(int state) {
		this.state = state;
		this.neighbours = new ArrayList<Node>();
		this.parent = null;
	}

	public Node(int state, boolean visited, List<Node> neighbours, Node parent) {
		super();
		this.state = state;
		this.visited = visited;
		this.neighbours = neighbours;
		this.parent = parent;
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

}
