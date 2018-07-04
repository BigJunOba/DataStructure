package bigjun.iplab.adjacencyMatrix;

public class TheShortestPath_Dijkstra {

	private static int[] P;			// 若P[v]=w，则表示V0到Vv的最短路径上，顶点Vv的前驱是Vw
	private static int[] D;			// V0到其他各个顶点的最小权值
	public final static int INFINITY = Integer.MAX_VALUE;
	
	public static void Dijkstra(AdjacencyMatrixGraphINF G, Object V0) throws Exception {

		int v;
		int v0 = G.locateVex(V0);
		int vexNum = G.getVexNum();  				// 顶点数
		P = new int[vexNum];
		D = new int[vexNum];
		boolean[] finish = new boolean[vexNum];		// finish[v]=true时，说明已经求得了从v0到v的最短路径
		for (v = 0; v < vexNum; v++) {
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			P[v] = -1;
		}
		D[v0] = 0;
		finish[v0] = true;					// 已求得v0到v0的最短路径
		v = -1;
		for (int i = 1; i < vexNum; i++) {	// 求得V0到顶点Vi的最短路径
			int min = INFINITY;
			for (int w = 0; w < vexNum; w++) {	// 求得当前到v0顶点的最近距离
				if (!finish[w]) {
					if (D[w] < min) {
						v = w;
						min = D[w];
					}
				}
			}
			finish[v] = true;
			// 在已知V0与V[v]的最短路径的基础上，对V
			for (int w = 0; w < vexNum; w++) {	// 更新当前最短路径及距离
				if (!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w] < D[w])) {
					D[w] = min + G.getArcs()[v][w];
					P[w] = v;
				}
			}
		}
		System.out.println("V0到其他各个顶点的最短路径的权值之和为: ");
		for (int i = 1; i < D.length; i++) {
			System.out.println("V0-" + G.getVex(i).toString() + ": " + D[i]);
		}
		System.out.println();
		System.out.println("V0到其他各个顶点的最短路径的倒序为: ");
		for (int i = 1; i < vexNum; i++) {
			System.out.print("从" + G.getVex(i) + "到V0的最短路径为: ");
			int j = i;
			while (P[j] != -1) {
				System.out.print(G.getVex(P[j]) + " ");
				j=P[j];
			}
			System.out.println();
		}
	}
	
}
