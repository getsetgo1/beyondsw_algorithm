package A2Dfs;

import java.util.ArrayList;
import java.util.List;

public class D3Basic3 {
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        int[][] arr = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{4,8},{4,9},{5,10}};
        adjList = new ArrayList<>();
        for(int i =0;i<11;i++) adjList.add(new ArrayList<>());
        for(int[] a:arr) adjList.get(a[0]).add(a[1]);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        dfs(answer,temp,1);
        System.out.println(answer);

    }
    static void dfs(List<List<Integer>> answer , List<Integer> temp,int start ){
//        for(){
            // 이렇게 계속 던져야겠지?
            //dfs(answer,temp,xx)
//        }
        if(adjList.get(start).isEmpty()){
            answer.add(new ArrayList<>(temp));
        }
        for(int target : adjList.get(start)){
            temp.add(target);
            dfs(answer,temp,target);
            temp.remove(temp.size()-1);
        }
    }


}
