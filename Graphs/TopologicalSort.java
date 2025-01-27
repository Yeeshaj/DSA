package Graphs;

import java.util.*;

public class TopologicalSort {
    

    public static List<Integer> khansAlgo(List<List<Integer>> graph, int vertices )
    {
        List<Integer> ans = new ArrayList<>();

        int indegree[] = new int[vertices];

        for(int i = 0 ; i < graph.size(); i++)
        {
            for(int j = 0 ; j < graph.get(i).size(); j++)
            {
                indegree[graph.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < vertices; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty())
        {
            int node = q.poll();

            ans.add(node);

            for(int neighbour : graph.get(node))
            {
                indegree[neighbour]--;

                if(indegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }

        if(ans.size() != vertices )
            return null; // cycle exits

        return ans;

    }

    public static void main(String[] args) {
        int n = 6; // Number of vertices
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges
        // adjList.get(5).add(2);
        // adjList.get(5).add(0);
        // adjList.get(4).add(0);
        // adjList.get(4).add(1);
        // adjList.get(2).add(3);
        // adjList.get(3).add(1);

        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(0);

       
            List<Integer> topoOrder = khansAlgo(adjList,n);
            if(topoOrder == null)
                System.out.println("Cycle Exists!");
            else
                System.out.println("Topological Order: " + topoOrder);
       
    }
}
