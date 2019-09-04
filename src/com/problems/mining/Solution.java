package com.problems.mining;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private int[][] map;

    public int findMaxPath(int[][] graph) {
        if (graph.length < 1 || graph[0].length < 1)
            return -1;

        map = graph;

        boolean[][] visited = new boolean[getRows()][getColumns()];
        Stack<Position> stack = new Stack<>();
        for(int i = 0; i < getRows(); i++) {
            for(int j = 0; j < getColumns(); j++) {
                visited[i][j] = isBarrier(i, j);
                List<Position> adjacentMinerals = getAllAdjacentMinerals(i, j);
                if (adjacentMinerals.size() == 1)
                    stack.push(new Position(i, j));
            }
        }

        int maxVal = 0;
        while (!stack.isEmpty()) {
            Position start = stack.pop();
            if (!visited[start.x][start.y])
                maxVal = Math.max(maxVal, dfs(visited, start.x, start.y));
        }

        return maxVal;
    }

    private int dfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        List<Position> adjacent = getAllAdjacentMinerals(x, y);
        List<Position> available = getAvailableAdjacentMierals(visited, adjacent);

        if (available.size() == 0)
            return map[x][y];

        int maxVal = 0;
        for (Position p : available) {
            int res = map[x][y] + dfs(visited, p.x, p.y);
            maxVal = Math.max(res, maxVal);
        }

        return maxVal;
    }

    private int getRows() {
        return map.length;
    }

    private int getColumns() {
        return map[0].length;
    }

    private boolean isBarrier(int x, int y) {
        return (x < 0 || x >= getRows() || y < 0 || y >=getColumns() || map[x][y] == -1);
    }

    private List<Position> getAllAdjacentMinerals(int x, int y) {
        List<Position> res = new ArrayList<Position>();
        if (!isBarrier(x, y-1)) res.add(new Position(x, y-1));
        if (!isBarrier(x, y+1)) res.add(new Position(x, y+1));
        if (!isBarrier(x-1, y)) res.add(new Position(x-1, y));
        if (!isBarrier(x+1, y)) res.add(new Position(x+1, y));

        return res;
    }

    private List<Position> getAvailableAdjacentMierals(boolean[][] visited, List<Position> adjacent) {
        List<Position> list = new ArrayList<>();

        for (Position p : adjacent) {
            if (!visited[p.x][p.y])
                list.add(p);
        }

        return list;
    }

    private class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqual(Position p) {
            return (p != null) && (x == p.x && y == p.y);
        }
    }
}
