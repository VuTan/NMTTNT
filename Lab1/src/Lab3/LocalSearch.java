package Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	public SortedMap<Integer, List<Integer>> generateNeighbours(Node node) {
		SortedMap<Integer, List<Integer>> sorted = new TreeMap<Integer, List<Integer>>();
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = 0; j < node.state.size(); j++) {
				List<Integer> ls = new ArrayList<Integer>();
				for (Integer n : node.state) {
					ls.add(n);
				}
				Node changeNode = new Node(j, ls);
				if (node.state.get(i) != j) {
					sorted.put(tryMovingOneQueen(changeNode, i, j), changeNode.state);
				}
			}
		}
		return sorted;
	}

	public void run() {
		Node initial = new Node(8); // hoặc 4,5,6,7
		if (heuristic(initial) == 0) // goal
		{
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, List<Integer>> sortMap = generateNeighbours(node);
		Integer bestHeuristic = sortMap.firstKey();
		int count = 0;
		while (bestHeuristic < heuristic(node)) {
			node.state = sortMap.get(bestHeuristic);
			System.out.println("Node " + node.state);
			sortMap = generateNeighbours(node);
			bestHeuristic = sortMap.firstKey();
			count++;
			if (count > 15)
				break;
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else {
			System.out.println("Cannot find goal state! Best state is: " + node.state);
			System.out.println(heuristic(node));
		}
	}

	public static void main(String[] args) {
		LocalSearch test = new LocalSearch();
		test.run();
//		Node node = new Node(6, new ArrayList<Integer>(Arrays.asList(1, 3, 0, 0, 1, 4)));
//		System.out.println(node.state);
//		SortedMap<Integer, List<Integer>> neighbours = test.generateNeighbours(node);
//		System.out.println(neighbours.values());
	}
}
