
public class Node implements Comparable<Node>{
	int endNode;
	double weight;
	public Node(int end, double w){
		endNode = end;
		weight = w;
	}
	@Override
	public int compareTo(Node o) {
		if(this.weight==o.weight){
			return (this.endNode-o.endNode);
		}
		int v = Double.compare(this.weight,o.weight);
		if(v<0) return -1;
		if(v>0) return 1;
		return 0;
	}
}