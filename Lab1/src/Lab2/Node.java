package Lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
	int n;
	List<Integer> state;
	List<Node> neighbours;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public boolean isValid(List<Integer> state) {
		if (state.size() == 1) {
//			System.out.println("0");
			return true;
		}
		if (state.size() > 1) {
			int stateChecked = state.get(state.size()-1);
			for (int i = 0; i < state.size()-1; i++) {
				if (state.get(i) == stateChecked) {
//					System.out.println("1");
					return false;
				}
				if (state.get(i) == stateChecked + (state.size() - 1 - i)
						|| state.get(i) == stateChecked - (state.size() - 1 - i)) {
//					System.out.println("2");
					return false;
				}
			}
		}

		return true;
	}

	private List<Integer> place(int x) {
		List<Integer> stateClone = new ArrayList<Integer>(state);
		stateClone.add(x);
		if (isValid(stateClone))
			return stateClone;
		return null;
	}

	public List<Node> getNeighbours() {
		if (state.size() == n) {
			return null;
		}
		for (int i = 0; i < n; i++) {
			List<Integer> checkState = place(i);
			if (checkState != null) {
				Node node = new Node(n, checkState);
				neighbours.add(node);
			}
		}
		return neighbours;
	}

	public static void main(String[] args) {
		Node n = new Node(4);

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(0);
		ls.add(2);
//		ls.add(3);
//		ls.add(1);
		System.out.println(ls);
		System.out.println(n.isValid(ls));

//		n.getNeighbours();
//		for (Node nd : n.neighbours) {
//			nd.getNeighbours();
//			for (Node nd2 : nd.neighbours) {
//				System.out.println(nd2.state);
//			}
//		}
	}
}
