/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cci_chap4_buildorder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Ali
 */
public class Graph 
{
    private final LinkedList<Integer> adj[];
    int V;
    
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    
    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();
        
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++)
        {
            visited[i] = false;
        }
        
        for (int i=0; i<V; i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(i, stack, visited);
            }
        }
        
        while(!stack.isEmpty())
            System.out.print(stack.pop()+", ");
    }
    
    private void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] visited)
    {
        visited[v] = true;
        int i;
        
        //Recur for all verticwes adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
            {
                topologicalSortUtil(i, stack, visited);
            }
        }
        
        //push current vertex to stack
        stack.push(v);
    }
}
