
public class Edge implements Comparable<Edge>{
	int startNode;
	int endNode;
	double weight;
	public Edge(int start, int end, double w){
		startNode = start;
		endNode = end;
		weight = w;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.weight==o.weight){
			return (this.endNode-o.endNode);
		}
		int v = Double.compare(this.weight,o.weight);
		if(v<0) return -1;
		if(v>0) return 1;
		return 0;
	}
}