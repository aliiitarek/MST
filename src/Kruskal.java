import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal implements MST{

	private double[][] AdjMatrix;
	private int number_Nodes;
	private int number_edges;
	private PriorityQueue<Edge> pq;
	private Edge[] MST;
	private boolean MST_Constructed = false;
	private long TimeExecution;
	private double weightMST;
	private final double INF = 1000000000;

	public Kruskal(){
		
	}

	public void readInput()throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strtok;
		System.out.println("Enter Number of Nodes in the Input Graph ...");
		strtok = new StringTokenizer(in.readLine());
		number_Nodes = Integer.parseInt(strtok.nextToken());
		System.out.println("Enter Number of Edges in the Input Graph ...");
		strtok = new StringTokenizer(in.readLine());
		number_edges = Integer.parseInt(strtok.nextToken());
		AdjMatrix = new double[number_Nodes][number_Nodes];
		for(int i=0;i<number_Nodes;i++){
			for(int j=0;j<number_Nodes;j++){
				AdjMatrix[i][j] = INF;
			}
		}
		pq = new PriorityQueue<>();
		System.out.println("**Now you will Construct the Graph**");
		System.out.println("***************************************************************");
		System.out.println("Enter StartNode,EndNode,Weight for the "+number_edges+" edges ;Space Separated");
		System.out.println("***************************************************************");
		for(int i=0;i<number_edges;i++){
			String[] line = in.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			double w = Double.parseDouble(line[2]);
			AdjMatrix[x-1][y-1] = w;
			AdjMatrix[y-1][x-1] = w;
			Edge edge = new Edge(x, y, w);
			pq.add(edge);
		}
	}

	public void computeMST(){
		weightMST = 0;
		long T1 = System.currentTimeMillis();
		int number_Edges_MST = number_Nodes-1;
		MST = new Edge[number_Edges_MST];
		UnionFindSet set = new UnionFindSet(number_Nodes);
		while(!pq.isEmpty() && number_Edges_MST>0){
			Edge currentEdge = pq.poll();
			if(!set.areConnected(currentEdge.startNode, currentEdge.endNode)){
				number_Edges_MST--;
				MST[number_Edges_MST] = currentEdge;
				weightMST += currentEdge.weight;
				set.Union(currentEdge.startNode, currentEdge.endNode);
			}
		}
		if(number_Edges_MST==0)
			MST_Constructed = true;
		else 
			MST_Constructed = false;
		long T2 = System.currentTimeMillis();
		TimeExecution = T2-T1;
	}

	public boolean isMSTConstructed(){
		return MST_Constructed;
	}

	public void printTimeExcecution(){
		if(isMSTConstructed()){
			System.out.println("***************************");
			System.out.println("Time For Excecution = "+TimeExecution+" millisecond");
			System.out.println("***************************");
		}else System.out.println("No time -->MST DisConnected<--");
	}

	public void printMST(){
		if(isMSTConstructed()){
			System.out.println("********************");
			System.out.println("MST from >>Kruskal<<");
			System.out.println("********************");
			for(int i=0;i<MST.length;i++){
				Edge e = MST[i];
				System.out.println("("+e.startNode+") <- "+e.weight +" -> ("+e.endNode+")");
			}
		}else System.out.println("Can't print -->MST DisConnected<--");
	}

	public void printWeightMST(){
		if(isMSTConstructed()){
			System.out.println("*********************");
			System.out.println("Weight of MST = "+weightMST);
			System.out.println("*********************");
		}else System.out.println("No weight -->MST DisConnected<--");
		
	}

	public static void main(String[] args) throws Exception {
		Kruskal k = new Kruskal();
		k.readInput();
		k.computeMST();
		k.printMST();
		k.printTimeExcecution();
		k.printWeightMST();
	}
}

