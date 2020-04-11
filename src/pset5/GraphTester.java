package pset5;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;

public class GraphTester {
	
	// tests for method "addEdge" in class "Graph"
	@Test public void tae0() {
		Graph g = new Graph(2);
		g.addEdge(0, 1);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
	}
	
	// your tests for method "addEdge" in class "Graph" go here
	// you must provide at least 4 test methods;
	// each test method has at least 1 invocation of addEdge;
	// each test method creates exactly 1 graph
	// each test method creates a unique graph w.r.t. "equals" method
	// each test method has at least 1 test assertion;
	// your test methods provide full statement coverage of your
	// implementation of addEdge and any helper methods
	// no test method directly invokes any method that is not
	// declared in the Graph class as given in this homework
	// ...
	@Test public void tae1() {
		Graph g = new Graph(3);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, true, false], [false, false, true], [false, false, false]]");
	}
	
	@Test public void tae2() {
		Graph g = new Graph(3);
		g.addEdge(-1, 1);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, false]]");
	}
	
	@Test public void tae3() {
		Graph g = new Graph(3);
		g.addEdge(3, 1);
		g.addEdge(0, 0);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[true, false, false], [false, false, false], [false, false, false]]");
	}
	
	@Test public void tae4() {
		Graph g = new Graph(3);
		g.addEdge(0, -1);
		g.addEdge(2, 2);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, false, false], [false, false, true]]");
	}
	
	@Test public void tae5() {
		Graph g = new Graph(3);
		g.addEdge(0, 3);
		g.addEdge(1, 1);
		System.out.println(g);
		assertEquals(g.toString(), "numNodes: 3\nedges: [[false, false, false], [false, true, false], [false, false, false]]");
	}
	
	// tests for method "reachable" in class "Graph"
	@Test public void tr0() {
		Graph g = new Graph(1);
		Set<Integer> nodes = new TreeSet<Integer>();
		nodes.add(0);
		assertTrue(g.reachable(nodes, nodes));
	}
	
	// your tests for method "reachable" in class "Graph" go here
	// you must provide at least 6 test methods;
	// each test method must have at least 1 invocation of reachable;
	// each test method must have at least 1 test assertion;
	// at least 2 test methods must have at least 1 invocation of addEdge;
	// your test methods must provide full statement coverage of your
	// implementation of reachable and any helper methods
	// no test method directly invokes any method that is not
	// declared in the Graph class as given in this homework
	// ...
	
	@Test public void tr1() {
		Graph g = new Graph(3);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(0);
		source.add(1);
		source.add(2);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		targets.add(2);
		assertTrue(g.reachable(source, targets));
	}
	
	@Test public void tr2() {
		Graph g = new Graph(2);
		g.addEdge(1, 0);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(1);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		assertTrue(g.reachable(source, targets));
	}
	
	@Test public void tr3() {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(2);
		assertTrue(g.reachable(source, targets));
	}
	
	@Test public void tr4() {
		Graph g = new Graph(4);
		g.addEdge(3, 0);
		g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 3);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(3);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		targets.add(2);
		targets.add(3);
		assertTrue(g.reachable(source, targets));
	}
	
	@Test public void tr5() {
		Graph g = new Graph(3);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(1);
		source.add(2);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		targets.add(2);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr6() {
		Graph g = new Graph(4);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(0);
		source.add(1);
		source.add(2);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(3);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr7() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(5);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr8() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(-2);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr9() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(2);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(0);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr10() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(1);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(2);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr11() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(1);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(5);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	@Test public void tr12() {
		Graph g = new Graph(2);
		Set<Integer> source = new TreeSet<Integer>();
		source.add(1);
		source.add(0);
		Set<Integer> targets = new TreeSet<Integer>();
		targets.add(-1);
		targets.add(1);
		assertFalse(g.reachable(source, targets));
	}
	
	
	
}
