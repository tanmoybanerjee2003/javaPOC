/**
 * 
 */
package com.redmart.interview.tanb.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Directed graph for detecting a cycle
 * 
 * @author tanmoy
 *
 */
public class Digraph<V> {
	/*
	 * Directed edge outside
	 */
	public static class Edge<V> {
        private V vertex;

        public Edge(V v) {
            vertex = v;
        }
    }
	
	private Map<V, Set<Edge<V>>> neighbors = new HashMap<V, Set<Edge<V>>>();
	
	private boolean traverse(V from, Map<V, Boolean> traversalMap) {
		//check for marker
		Boolean isBeingTraversed = traversalMap.get(from);
		if((isBeingTraversed != null) && isBeingTraversed.booleanValue()) {
			//cycle exists
			return true;
		}
		//mark for traversal
		traversalMap.put(from, true);
		
		Set<Edge<V>> edges = neighbors.get(from);
		if(edges == null) {
			//nothing to traverse
			//mark end of traversal
			traversalMap.put(from, false);
			return false;
		} else {
			for(Edge<V> edge : edges) {
				//traverse all children
				boolean isCyclePresent = traverse(edge.vertex, traversalMap);
				if(isCyclePresent) {
					return true;
				}
			}
			
			//mark end of traversal
			traversalMap.put(from, false);
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param from
	 * @param to
	 */
	public void add(V from, V to) {
		if(neighbors.containsKey(from)) {
			//vertex already present
			Set<Edge<V>> edges = neighbors.get(from);
			boolean edgeFound = false;
			if(edges != null) {
				for(Edge<V> edge : edges) {
					if(edge.vertex == to) {
						//no need to add
						edgeFound = true;
						break;
					}
				}
			}
			if(!edgeFound) {
				if(edges ==  null) {
					edges = new HashSet<Edge<V>>();
				}
				//add this edge
				edges.add(new Edge<V>(to));
				//update the graph
				neighbors.put(from, edges);
			}
		} else {
			//add vertex and its edge
			Set<Edge<V>> edges = new HashSet<Edge<V>>();
			edges.add(new Edge<V>(to));
			neighbors.put(from, edges);
		}
		
		//add "to" vertex also
		if(!neighbors.containsKey(to)) {
			neighbors.put(to, null);
		}
	}
	
	/**
	 * Return on detecting first cycle
	 * 
	 * @return true if cycle is present
	 */
	public boolean checkForCycle() {
		boolean cyclePresent = false;
		Map<V, Boolean> traversalMap = new HashMap<V, Boolean>();
		
		for(V vertex : neighbors.keySet()) {
			cyclePresent = traverse(vertex, traversalMap);
			if(cyclePresent) {
				break;
			}
		}
		
		return cyclePresent;
	}
}
