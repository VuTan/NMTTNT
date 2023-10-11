package Lab2;

import java.util.Stack;

public class DFS {
	public Node dfsUsingStack(Node initial, int goal) {
		Node node = initial;
		if (node.state.size() == goal) {
			return node;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			node.getNeighbours();
			if (node.state.size() == goal) {
				System.out.println(node.state);
				return node;
			} else {
				for (Node n : node.neighbours) {
						stack.add(n);
				}
			}
		}
		return null;
	}
}
