package com.graph;

import java.util.ArrayList;

/**
 * Detect Cycle in a directed graph
 */
public class DirectedCycle {
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph, boolean[] visited, boolean[] rec, int curr) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int dest = graph[curr].get(i).getDest();
            if (rec[dest])
                return true;

            if(detectCycle(graph, visited, rec, dest))
                return true;
        }
        rec[curr] = false;

        return false;

    }

    public static void main(String[] args) {
        /** 1-->0 <----- 3
         *      \      d
         *       d   /       *
         *        2
         *
         *


         */

        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[graph.length];
        boolean[] rec = new boolean[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(visited[i]) continue;
            boolean flag=detectCycle(graph, visited, rec, i);
            if(flag) {
                System.out.println("Cycle Detected:=>" + flag);
                break;
            }
        }
    }
}
