package Lab2;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public Node bfsUsingQueue(Node initial, int goal) {
		Node node = initial;
		if (node.state.size() == goal) {
			return node;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.getNeighbours();
			if (node.state.size() == goal) {
				System.out.println(node.state);
				return node;
			} else {
				for (Node n : node.neighbours) {
						queue.add(n);
				}
			}
		}
		return null;
	}
}
