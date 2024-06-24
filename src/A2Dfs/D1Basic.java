package A2Dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D1Basic {
    // 이런 문제는 주로 관계 관련 리스트를 따로 뽑는 게 일반적
    // 관계 리스트가 없는 경우 각 값 찾을 때마다 for문 이중 써서 찾아야되서 list로 따로 뽑는 것
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{1,3},{2,3},{2,4}};
        // 위가 일반적인 표현식
        // 다른 표현식으로는
        // int[][] arr2 = {{1,1,1,0,0},{0,1,0,1,0},...};
        // 0번 노드가 갈 수 있으면 1 못 가면 0, 즉 0한테 0,1,2는 갈 수 있고 3,4는 못 가는 거 표현

        // 방문할 수 있는 정점이 여러개인 경우 정점 변호가 작은 것을 먼저 방문하는
        // DFS 알고리즘 형시의 방문 순서를 출력하라
        // 결과값은 0,1,3,2,4가 나와야한다.

        adjList=new ArrayList<>();
        for(int i=0;i<5;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] a: arr){
            adjList.get(a[0]).add(a[1]);
            // 0->1 && 1->0 과 같은 양방향일 경우
            // adjList.get(a[1]).add(a[0]);
        }
        visited = new boolean[5];
        dfs(0);
    }
    static void dfs(int start){
//        if(adjList.get(start)) // 이렇게 해서 값이 있는지 체크해서 해도 됨 아래랑 같아
        System.out.println(start);
        visited[start] = true;
        for( int target: adjList.get(start)){
            if(visited[target]==false) dfs(target);
        }
    }
}
