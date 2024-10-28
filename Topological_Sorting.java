import java.util.*;
public class TopologicalSortDFS 
{
    public static void topologicalSortUtil(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) 
    {
        visited[node] = true;
        for (int neighbor : adj.get(node)) 
        {
            if (!visited[neighbor])
            {
                topologicalSortUtil(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }
    public static void topologicalSort(int vertices, List<List<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }
   public static void main(String[] args)
   {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
       for (int i = 0; i < vertices; i++)
       {
            adj.add(new ArrayList<>());
       }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        topologicalSort(vertices, adj);
    }
}
