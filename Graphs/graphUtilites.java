package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class graphUtilites  extends Graph{

    void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }

    void printGraph()
    {
        for(int i = 0; i < vertices; i++)
        {
            System.out.print(i + " -> ");
            for(int j = 0; j < edges.get(i).size(); j++)
            {
                System.out.print(edges.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    // BFS Time Complexity: O(V+E)
    void BFS(int start)
    {
        boolean visited[] = new boolean[vertices];
        Queue<Integer> q = new LinkedList<Integer>();;
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty())
        {
            int node = q.poll();
            System.out.println(node+" -> ");
            for(int v : edges.get(node))
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    q.add(v);
                }
            }   
        }
    }

    // Time Complexity: O(V+E)
    void DFS(int start)
    {
        boolean visited[] = new boolean[vertices];
        DFSUtil(start, visited);
    }

    void DFSUtil(int start, boolean visited[])
    {
        visited[start] = true;
        System.out.println(start + " ->");
        for(int v : edges.get(start))
        {
            if(!visited[v])
            {
                visited[v] = true;
                DFSUtil(start, visited);
            }
        }
    }
}
