package Graphs;

import java.util.*;

public class Graph
{
    int data;
    ArrayList<ArrayList<Integer>> edges;
    int vertices;

    Graph()
    {
        edges =  new ArrayList<>();
    }
    
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

    

    

}