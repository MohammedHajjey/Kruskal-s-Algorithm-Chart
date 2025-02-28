package kruskalalgorimasi;
import java.util.*;

public class KruskalAlgorimasi {

    int parents[] = new int[1000];
    int find(int item){
        if (parents[item] == item) {
            return item;
        }
        return find(parents[item]);
    }
    
    void unite(int x, int y){
        int fx = find(x);
        int fy =find(y);
        parents[fx]  = fy; 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        KruskalAlgorimasi vertex = new KruskalAlgorimasi();
        
        for (int i = 0; i < 1000; i++) {
            vertex.parents[i]= i; 
            
        }
        int vertexNumber, edgesNumber;
        int edge1, edge2, weight;
        
        
        ArrayList<EdgeInformation> edges = new ArrayList<>();
        System.out.println("input how many vertex in the graph");
        vertexNumber = scanner.nextInt();
        
        int[][] calculatedEdges = new int[vertexNumber][vertexNumber];
        int[] weights = new int[vertexNumber];
        System.out.println("input how many Edges in the graph");
        edgesNumber = scanner.nextInt();
        
        System.out.println("input edges  in this format  e1 , e2 , weight");
        for (int i = 0; i < edgesNumber; i++) {
            edge1 = scanner.nextInt();
            edge2 = scanner.nextInt();
            weight = scanner.nextInt();
            
            edges.add(new EdgeInformation(edge1, edge2, weight));
            
            
            
        }
        System.err.println("");
        
        int mst_weight = 0, mst_edges = 0;
        int mst_index = 0;
        //Collections.sort(edges, (EdgeInformation p1, EdgeInformation p2) -> p1.weight - p2.weight);
        Collections.sort(edges, new Comparator<EdgeInformation>() {
            @Override
            public int compare(EdgeInformation p1, EdgeInformation p2) {
                return p1.weight - p2.weight;
            }
        });
        
        int i=0;
        while ((mst_edges < vertexNumber-1) || (mst_index < edgesNumber)) {
            edge1 = edges.get(mst_index).edge1;
            edge2 = edges.get(mst_index).edge2;
            weight = edges.get(mst_index).weight;
            if (vertex.find(edge1) != vertex.find(edge2)) {
                vertex.unite(edge1, edge2);
                mst_weight += weight;
                System.err.println(edge1 +" " +edge2 + " " +weight);
                calculatedEdges[edge1][edge2] = weight;
                weights[i]= weight;
                i++;
                mst_edges++;
                
            }
            mst_index++;
       
            
        }
        Graphic g = new Graphic(weights);
        System.out.println("\n Weight of the mst is " + mst_weight);
        
    }
    
}
/*
7 9
1 2 4
7 2 2
6 2 3
6 5 1
5 3 20
4 3 6 
1 4 7
2 5 2
2 3 1

10 16
1 2 4 
2 3 4 
1 4 1 
4 2 4 
3 5 2 
3 6 1 
5 7 2 
6 7 3 
6 9 5 
7 9 3 
7 10 4 
9 10 3 
8 10 2 
2 10 10 
4 10 6 
4 8 5 




*/