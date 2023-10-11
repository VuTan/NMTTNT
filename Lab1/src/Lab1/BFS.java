package Lab1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void bfsUsingQueue(Node initial, int goal) {
		Node node = initial;
		if (node.state == goal) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		node.visited = true;
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			for (Node n : node.neighbours) {
				if (n.state == goal) {
					String s = "";
					while (node != initial) {
						s = node.state + " " + s;
						node = node.parent;
					}
					System.out.println(initial.state + " " + s);
					return;
				}
				if (n.visited != true) {
					n.parent = node;
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}
}
