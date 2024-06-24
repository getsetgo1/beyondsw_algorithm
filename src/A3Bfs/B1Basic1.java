package A3Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B1Basic1 {

    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{1,3},{2,3},{2,4}};
        adjList=new ArrayList<>();
        visited=new boolean[5];
        for(int i=0;i<5;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a: arr){
            adjList.get(a[0]).add(a[1]);
        }
        // bfs로 나오는 각 노드 방문하고 출력
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int temp=queue.poll();
            System.out.println(temp);
            for(int target : adjList.get(temp)){
                // target을 queue에 add하기 전에 true로 세팅
                // temp를 true로 세팅한 후 for문 들어가면 for문 안에서 temp가 true여야하는 곳에서 false인 상태일 수 있음
                if(visited[target]==false) {
                    queue.add(target);
                    visited[target]=true;
                }
            }
        }
    }
}

