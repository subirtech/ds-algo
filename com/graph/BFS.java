package com.graph;

import java.util.*;

/**
 * BFS of a graph. Number of edges is E and number of vertex is V.
 * Complexity O(E+V)
 */
class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}

public class BFS {

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));


    }

    public static void printAdjacencyList(ArrayList<Edge>[] graph)
    {
         for (int i = 0; i < graph.length; i++) {
            ArrayList<Edge> edges = graph[i];
            System.out.println("Source :=>" + i);
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j).getDest() + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

        if (graph.length == 0) return;
        int value;
        ArrayList<Edge> edges;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        while (!(queue.isEmpty())) {
            value = queue.remove();
            if (visited[value])
                continue;
            visited[value] = true;
            edges = graph[value];
            for (int i = 0; i < edges.size(); i++) {
                queue.add(edges.get(i).getDest());
            }
            System.out.print(value + " ");
        }
    }


    public static void main(String[] args) {

   /*    1---3
       /    |  \
      0     |   5 - 6
       \    |  /
        2---4  */

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        //printAdjacencyList(graph);
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            bfs(graph, i, visited);
        }
    }
}
