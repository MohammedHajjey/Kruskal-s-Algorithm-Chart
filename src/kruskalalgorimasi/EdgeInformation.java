package kruskalalgorimasi;

public class EdgeInformation {
    public int edge1,edge2,weight;

    public EdgeInformation(int edge1, int edge2, int weight) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.weight = weight;
    }
    public String toString(){
        return "" +this.weight;
    }    
}
