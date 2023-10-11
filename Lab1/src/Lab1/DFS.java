package Lab1;

import java.util.Stack;

public class DFS {
	public void dfsUsingStack(Node initial, int goal) {
		Node node = initial;
		if (node.state == goal) {
			return;
		}
		Stack<Node> stack = new Stack<Node>() ;
		node.visited = true;
		stack.add(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
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
					stack.add(n);
				}
			}
		}
	}
}
