import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Graph<T> {

    private final Map<T, List<T>> adjacency = new HashMap<>();

    void addVertex(T vertex) {
        adjacency.computeIfAbsent(vertex, key -> new ArrayList<>());
    }

    /**
     * Adds a one-way edge from {@code from} to {@code to}.
     *
     * <p>The destination is registered even if it has no outgoing edges.
     * This keeps the vertex count correct and lets BFS/DFS start from it.</p>
     */
    void addDirectedEdge(T from, T to) {
        adjacency.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
        addVertex(to);
    }

    void addUndirectedEdge(T first, T second) {
        addDirectedEdge(first, second);
        addDirectedEdge(second, first);
    }

    int vertexCount() {
        return adjacency.size();
    }

    List<T> bfs(T source) {
        List<T> traversal = new ArrayList<>();

        if (!adjacency.containsKey(source)) {
            return traversal;
        }

        Set<T> visited = new HashSet<>();
        Queue<T> queue = new ArrayDeque<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            traversal.add(vertex);

            for (T neighbor : adjacency.getOrDefault(vertex, List.of())) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        return traversal;
    }

    List<T> dfs(T source) {
        List<T> traversal = new ArrayList<>();

        if (adjacency.containsKey(source)) {
            dfs(source, new HashSet<>(), traversal);
        }

        return traversal;
    }

    private void dfs(T vertex, Set<T> visited, List<T> traversal) {
        if (!visited.add(vertex)) {
            return;
        }

        traversal.add(vertex);

        for (T neighbor : adjacency.getOrDefault(vertex, List.of())) {
            dfs(neighbor, visited, traversal);
        }
    }
}

public class GraphOps {

    public static void main(String[] args) {
        /*
         *       A
         *      / \
         *     B   C
         *     |   |
         *     D   E
         */
        Graph<String> stringGraph = new Graph<>();

        stringGraph.addUndirectedEdge("A", "B");
        stringGraph.addUndirectedEdge("A", "C");
        stringGraph.addUndirectedEdge("B", "D");
        stringGraph.addUndirectedEdge("C", "E");

        System.out.println("Vertices: " + stringGraph.vertexCount());
        System.out.println("BFS: " + stringGraph.bfs("A"));
        System.out.println("DFS: " + stringGraph.dfs("A"));
    }
}
