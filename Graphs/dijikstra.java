package Graphs;

import java.util.*;

public class dijikstra {
    

    public static int[] calculateDistance(List<List<Edge>> graph, int source, int vertices)
    {
        int distance[] = new int[vertices];

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        pq.add(new Edge(source, 0));

        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[source] = 0;

        while(!pq.isEmpty())
        {
            Edge current  = pq.poll();

            for(Edge neighbour : graph.get(current.target))
            {
                int newDistance = distance[current.target] + neighbour.weight;
                
                if(newDistance < distance[neighbour.target])
                {
                    distance[neighbour.target] = newDistance;

                    pq.add(new Edge(neighbour.target, newDistance));
                }
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices
        int source = 0; // Source vertex

        // Create a graph as an adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (u -> v, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 5));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 9));
        graph.get(3).add(new Edge(5, 6));
        graph.get(4).add(new Edge(5, 2));

        // Run Dijkstra's algorithm
        int[] distances = calculateDistance(graph, source, vertices);

        // Print shortest distances from the source to each vertex
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}

class Edge
{
    int target,weight;
    Edge(int target, int weight)
    {
        this.target = target;
        this.weight = weight;
    }
}
