package A3Bfs;

import java.util.*;

public class B1Basic3 {
    // 배열을 하나 만들어서, 이 배열이 각 노드가 start node 에서 얼마나 떨어져 있는지 숫자값 담기

    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        int[][] arr = {{0,1}, {0,2},{1,3},{2,3},{2,4}};

        // 초기화
        adjList = new ArrayList<>();
        visited = new boolean[5];
        distance = new int[5];

        for(int i = 0; i < 5; i++){
            adjList.add(new ArrayList<>()); // 빈 List 가 node 갯수 만큼 만들어진다.
        }
        for(int[] a : arr){
            adjList.get(a[0]).add(a[1]);
        }

        // bfs 로 각 나오는 각 노드 방문하고 출력
        // 0 -> 1 -> 2 -> 3 -> 4
        int start = 0;
        int end = 3;

    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll(); // 꺼내기
            // visited[temp] = true;
            System.out.println(temp);
            for (int target : adjList.get(temp)) {
                // target을 queue에 add 하기 전에 true로 세팅
                if (!visited[target]) {
                    queue.add(target);
                    distance[target] = distance[temp] + 1;
                    visited[target] = true;
                    if(target == end){ // target이 end까지 오면 그만 해라
                        return distance[target];
                    }
                }
            }
        }
        return -1;
    }
}
