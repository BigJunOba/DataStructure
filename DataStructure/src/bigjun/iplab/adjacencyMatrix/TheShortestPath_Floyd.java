package bigjun.iplab.adjacencyMatrix;

public class TheShortestPath_Floyd {

	private static int[][] D;			// 顶点到顶点的最短路径权值和矩阵
	private static int[][] P;			// 顶点的到顶点的最短路径的前驱矩阵
	public final static int INFINITY = Integer.MAX_VALUE;
	
	public static void Floyd(AdjacencyMatrixGraphINF G) throws Exception {
		
		int v, w ,k;
		int vexNum = G.getVexNum();
		P = new int[vexNum][vexNum];
		D = new int[vexNum][vexNum];
		for (v = 0; v < vexNum; v++) {
			for (w = 0; w < vexNum; w++) {
				D[v][w] = G.getArcs()[v][w];	// 初始化D矩阵为邻接矩阵
				P[v][w] = w;					// 初始化P矩阵，表示从v到w的最短路径的前驱是w，即直接到达的意思
			}
		}
		for (k = 0; k < vexNum; k++) {			// k值表示中转顶点的下标
			for (v = 0; v < vexNum; v++) {		// v值表示起始顶点的下标
				for (w = 0; w < vexNum; w++) {	// w值表示终止顶点的下标
					if (D[v][k] < INFINITY && D[k][w] < INFINITY &&	// 注意: 只限定两个不是正无穷就可以，否则会造成越界的情况
						D[v][w] > D[v][k] + D[k][w]) {	// 从v直接到w的权值和大于从v先到k再到w
						D[v][w] = D[v][k] + D[k][w];	// 更新从v到w的权值和
						P[v][w] = P[v][k];				// 路径设置为经过下标为k的顶点
					}
				}
			}
		}
		
		System.out.println("D矩阵为: ");
		for (v = 0; v < vexNum; v++) {
			for (w = 0; w < vexNum; w++) {
				System.out.print(D[v][w] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("P矩阵为: ");
		for (v = 0; v < vexNum; v++) {
			for (w = 0; w < vexNum; w++) {
				System.out.print(P[v][w] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("各个顶点之间的最短路径的权值和为: ");
		for (v = 0; v < vexNum; v++) {
			for (w = v + 1; w < vexNum; w++) {
				System.out.print(G.getVex(v) + "-");
				System.out.print(G.getVex(w) + " weight: ");
				System.out.println(D[v][w]);
			}
		}
		System.out.println();
		
		System.out.println("各个顶点之间的最短路径为: ");
		for (v = 0; v < vexNum; v++) {
			for (w = v + 1; w < vexNum; w++) {
				System.out.print(G.getVex(v) + "->");
				System.out.print(G.getVex(w) + " TheShortestPath: ");
				k = P[v][w];			// 获得第一个路径顶点下标
				System.out.print(G.getVex(v));
				while (k!=w) {
					System.out.print("->" + G.getVex(k));
					k = P[k][w];
				}
				System.out.println("->" + G.getVex(w));
			}
		}
		System.out.println();
	}
}
