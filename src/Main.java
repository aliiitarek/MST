import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main{
	public static void main (String[] args) throws java.lang.Exception
	{
		MST kruskal = new Kruskal();
		kruskal.readInput();
		kruskal.computeMST();
		kruskal.printMST();
		kruskal.printTimeExcecution();
		kruskal.printWeightMST();
//////		
//		System.out.println("******************************************************");
//		
		MST pMat = new Prim_AdjMatrix();
		pMat.readInput();
		pMat.computeMST();
		pMat.printMST();
		pMat.printTimeExcecution();
		pMat.printWeightMST();
		
//		System.out.println("******************************************************");
		
		MST pList = new Prim_AdjList();
		pList.readInput();
		pList.computeMST();
		pList.printMST();
		pList.printTimeExcecution();
		pList.printWeightMST();
	}
}