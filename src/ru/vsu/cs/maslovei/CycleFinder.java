package ru.vsu.cs.maslovei;

import java.util.*;

public class CycleFinder {
    public static Graph graph;
    public static TreeSet<Integer> checkVertices;
    public static Vector<Integer> curCycle;
    public static Vector<Vector<Integer>> vectorWithCycles = new Vector<>();

    public static Vector<Vector<Integer>> findCycle(Graph graph, TreeSet<Integer> notAllowVertices){
        CycleFinder.graph = graph;
        CycleFinder.curCycle = new Vector<>();

        for (int curVertex = 0; curVertex < graph.vertexCount(); curVertex++){
            if (!notAllowVertices.contains(curVertex)) {
                CycleFinder.checkVertices = notAllowVertices;
                curCycle.clear();
                curCycle.add(curVertex);
                checkEndCycle(curVertex);
            }
        }
        return vectorWithCycles;
    }

    public static void checkEndCycle(int v){
        for (int adjVertex : graph.adjacencies(v)){
            if ((!checkVertices.contains(adjVertex))
                    && ((curCycle.size() < 2) || (adjVertex != curCycle.get(curCycle.size() - 2)))) {
                if (adjVertex == curCycle.get(0)) {
                        Vector<Integer> addCycle = (Vector<Integer>) curCycle.clone();
                        addCycle.add(addCycle.get(0));
                        vectorWithCycles.add(addCycle);
                } else {
                    curCycle.add(adjVertex);
                    checkVertices.add(adjVertex);
                    checkEndCycle(adjVertex);
                    checkVertices.remove(adjVertex);
                    curCycle.removeElementAt(curCycle.size() - 1);
                }
            }
        }
    }
}
