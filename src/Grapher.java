import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Grapher {

	public double randomWeight(double Min, double Max) {

		return Min + (Math.random() * ((Max - Min) + 1));
	}

	public int randomNode(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min) + 1));
	}

	public void connectGraph(int n) {

		for (int i = 1; i < n ; i++) {
			System.out.println(i + " " + (i + 1) + " " + randomWeight(0, 1000));
		}

	}

	public void dense(int n) throws FileNotFoundException {
		System.setOut(new PrintStream(new File("dense.txt")));
		int numberOfNodes = n;
		System.out.println(numberOfNodes);
		int numberOfEdges = 0;
		for(int i=1;i<=numberOfNodes;i++){
			for(int j=(i+1);j<=numberOfNodes;j++){
				numberOfEdges++;
			}
		}
		System.out.println(numberOfEdges);

		for(int i=1;i<=numberOfNodes;i++){
			for(int j=(i+1);j<=numberOfNodes;j++){
				System.out.println(i + " " + j + " " + randomWeight(0, 1000));
			}
		}
	}

	public void sparse(int n, int e) throws FileNotFoundException {

		System.setOut(new PrintStream(new File("sparse.txt")));
		int numberOfNodes = n;
		System.out.println(numberOfNodes);
		int numberOfEdges = e;
		System.out.println(numberOfEdges);

		connectGraph(numberOfNodes);
		int newnumberOfEdges = numberOfEdges - (numberOfNodes - 1);

		for (int i = 0; i < newnumberOfEdges; i++) {
			System.out.println(randomNode(1, numberOfNodes ) + " "
					+ randomNode(1, numberOfNodes) + " "
					+ randomWeight(0, 1000));
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		new Grapher().sparse(100, 500);

	}

}