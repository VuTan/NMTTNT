package Lab3;

import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {

	public int checkHoriziontal(Node node) {
		int count = 0;
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				if (node.state.get(i) == node.state.get(j))
					count++;
			}
		}
		return count;
	}

	public int checkDiagonal(Node node) {
		int count = 0;
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				if (node.state.get(i) == node.state.get(j) - (j - i)) {
					count++;
				}
				if (node.state.get(i) == node.state.get(j) + (j - i)) {
					count++;
				}
			}
		}
		return count;
	}

	public int heuristic(Node node) {
		return checkDiagonal(node) + checkHoriziontal(node);
	}

	public int tryMovingOneQueen(Node node, int x, int y) {
		node.state.set(x, y);
		return heuristic(node);
	}

	public SortedMap<Integer, Node> generateNeighbours(Node node) {
		SortedMap<Integer, Node> sorted = new TreeMap<Integer, Node>();
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = 0; j < node.state.size(); j++) {
				if (node.state.get(i) != j) {
					sorted.put(tryMovingOneQueen(node, i, j), node);
				}
			}
		}
		return sorted;
	}

	/*
	 * 1 0 0 0 3 0 1 0 0 3 0 0 1 0 3 0 0 0 1 3 12 1 0 0 0 0 1 1 0 0 0 0 0 0 0 0 1
	 */

	public void run() {
		Node initial = new Node(8); // hoặc 4,5,6,7
		if (heuristic(initial) == 0) // goal
		{
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node);
		Integer bestHeuristic = neighbours.firstKey();
		while (bestHeuristic < heuristic(node)) {
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node);
			bestHeuristic = neighbours.firstKey();
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else
			System.out.println("Cannot find goal state! Best state is: " + node.state);
	}

	public static void main(String[] args) {
		LocalSearch test = new LocalSearch();
		test.run();
	}
}
