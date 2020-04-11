package pset5;

import java.util.Arrays;
import java.util.Set;
import java.util.*;

public class Graph {
	private int numNodes; // number of nodes in the graph
	private boolean[][] edges;
	// edges[i][j] is true if and only if there is an edge from node i to node j
	// class invariant: fields "edges" is non-null;
	// "edges" is a square matrix;
	// numNodes is number of rows in "edges"
	
	public Graph(int size) {
		numNodes = size;
		// your code goes here
		// ...
		edges = new boolean[size][size];
		
	}
	
	public String toString() {
		return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
	}
	
	public boolean equals(Object o) {
		if (o.getClass() != Graph.class) return false;
		return toString().equals(o.toString());
	}
	
	public void addEdge(int from, int to) {
		// postcondition: adds a directed edge "from" -> "to" to this graph
		// your code goes here
		//...
		if(from < numNodes && from >= 0 && to < numNodes && to >= 0) {
			edges[from][to] = true;
		}
		
	}
	
	public boolean reachable(Set<Integer> sources, Set<Integer> targets) {
		if (sources == null || targets == null) throw new IllegalArgumentException();
		// postcondition: returns true if (1) "sources" does not contain an illegal node
		// (2) "targets" does not contain an illegal node, and
		// (3) for each node "m" in set "targets", there is some
		// node "n" in set "sources" such that there is a directed
		// path that starts at "n" and ends at "m" in "this"; and
		// false otherwise
		// your code goes here
		//...
		for(Integer i : sources) {
			if(i >= numNodes || i < 0) {
				return false;
			}
		}
		
		for(Integer i : targets) {
			if(i >= numNodes || i < 0) {
				return false;
			}
		}
		
		Set<Integer> reachable = new HashSet<Integer>();
		Queue<Integer> startNodes = new LinkedList<Integer>();
		startNodes.addAll(sources);
		while(!startNodes.isEmpty()) {
			Integer current = startNodes.poll();
			reachable.add(current);
			for(int i = 0; i < edges[current].length; i++) {
				if(edges[current][i] == true) {
					reachable.add(i);
					startNodes.add(i);
				}
			}
		}
		if(reachable.containsAll(targets)) {
			return true;
		} else {
			return false;
		}
		
	}
}