package Lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node implements Cloneable {
	int n;
	List<Integer> state;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			Random r = new Random();
			this.state.add(r.nextInt(n));
		}
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Node [state=" + state + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
