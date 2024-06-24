package A2Dfs;

import java.util.ArrayList;
import java.util.List;

public class D2Basic2 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        // 이번엔 양방향, D1Basic은 단방향문제였음
        int[][] arr={{0,1},{0,2},{1,3},{2,3},{3,5},{2,4}};
        // 이거 왜 0-1-3-2-4-5?
        // 왜냐면 arr에 {2,3},{3,5} 이렇게 2,3이 먼저 들어가서 우선 처리되어서 0-1-3-2가 되는 것
        adjList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) adjList.add(new ArrayList<>());
        for(int[] a:arr){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        visited = new boolean[arr.length];
        dfs(0);
    }
    static void dfs(int start){
        System.out.println(start);
        visited[start]=true;
        for(int target:adjList.get(start)){
            if(visited[target]==false) dfs(target);
        }
    }

}
