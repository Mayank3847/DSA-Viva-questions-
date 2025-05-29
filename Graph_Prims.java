 import java.util.*;

public class Graph_Prims {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }

    }

    static class Pair implements Comparable<Pair> {
        int v, cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));


        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        
       graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }
    public static void Prism (ArrayList<Edge>graph[]){
        boolean[]isVisit=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!isVisit[curr.v]){
                isVisit[curr.v]=true;
                finalCost+=curr.cost;
                for(int i =0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);   
                    pq.add(new Pair(e.dest, e.weight));

                }

            }
        }
        System.out.println("MINIMUM SPANNING COST : "+finalCost);
    }
    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        Prism(graph);
    }

}
