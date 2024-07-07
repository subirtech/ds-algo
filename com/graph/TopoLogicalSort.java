package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Topological sorting
 * Time Coplexity O(V+E)
 */
public class TopoLogicalSort {

    private static void createGraph(List<Edge>[] graph, int vCount) {
        for (int i = 0; i < vCount; i++) {
            graph[i] = new ArrayList<>();
        }
       /*
       //Enable this block to generate cycle
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));*/
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    private static boolean detectCycle(List<Edge>[] graph, int curr, boolean[] vis, boolean[] rec) {

        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if (rec[graph[curr].get(i).getDest()])
                return true;
            if (!vis[graph[curr].get(i).getDest()]) {
                if (detectCycle(graph, graph[curr].get(i).getDest(), vis, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    private static void topShort(List<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> topStack) {

        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if (!vis[graph[curr].get(i).getDest()]) {
                topShort(graph, graph[curr].get(i).getDest(), vis, topStack);
            }

        }
        topStack.push(curr);
    }

    private static boolean detectCycle(List<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] rec = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycle(graph, i, vis, rec) == true)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Edge>[] graph = new ArrayList[6];
        createGraph(graph, 6);
        Stack<Integer> topStack = new Stack<>();
        if (!detectCycle(graph)) {
            boolean[] vis = new boolean[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (!vis[i]) {
                    topShort(graph, i, vis, topStack);
                }
            }
        } else {
            System.out.println("Cycle detected. Topological sort is not possible.");
        }
        while (!topStack.isEmpty()) {
            System.out.print(topStack.pop() + "  ");
        }
    }
}
