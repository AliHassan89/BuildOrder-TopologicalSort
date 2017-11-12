/*

Build Order: You are given a list of projects and a list of dependencies (which 
is a list of pairs of projects, where the second project is dependent on the 
first project). All of a project's dependencies must be built before the project
is. Find a build order that will allow the projects to be built. If there 
is no valid build order, return an error.

EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c

*/
package cci_chap4_buildorder;

/**
 *
 * @author Ali
 */
public class CCI_Chap4_BuildOrder 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        Graph graph = new Graph(7);
        graph.addEdge(1, 4);
        graph.addEdge(6, 2);
        graph.addEdge(6, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        
        graph.topologicalSort();
    }
    
}
