package Graphs;
import java.util.*;
public class Graph
{
    int data;
    ArrayList<ArrayList<Integer>> edges;
    int vertices;
    Graph(int vertices)
    {
        edges =  new ArrayList<>();

        this.vertices = vertices;
        
        // To add no of edges
        for(int i = 0; i < vertices; i++)
        {
            edges.add(new ArrayList<>());
        }
    }

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
    
}