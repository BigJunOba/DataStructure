package bigjun.iplab.adjacencyMatrix;

import java.util.Scanner;

public class AdjMatGraph implements AdjacencyMatrixGraphINF{
	
	private final static int INFINITY = Integer.MAX_VALUE;	// 表示正无穷
	private GraphKind kind;			// 图的种类标志
	private int vexNum, arcNum;		// 顶点数，边数
	private Object[] vexs;			// 顶点一维数组
	private int[][] arcs;			// 邻接矩阵
	
	// 构造方法1: 构造一个空图
	public AdjMatGraph() {
		this(null, 0, 0, null, null);
	}
	
	// 构造方法2: 构造一个非空图
	public AdjMatGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}
	
	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返回边数
	public int getArcNum() {
		return arcNum;
	}

	// 返回邻接矩阵
	public int[][] getArcs() {
		return arcs;
	}

	// 返回顶点数组
	public Object[] getVexs() {
		return vexs;
	}

	// 创建图的四种类型中的一种
	public void createGraph() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入图的类型代号(UDG(无向图)、DG(有向图)、UDN(无向网)、DN(有向网)):");
		kind = GraphKind.valueOf(scanner.next());
		switch (kind) {
		case UDG:
			createUnDirecedGraph();
			return;
		case DG:
			createDirectedGraph();
			return;
		case UDN:
			createUnDirectedNet();
			return;
		case DN:
			createDirectedNet();
			return;
		}
		System.out.println("图已创建完成！");
	}
	
	// 创建无向图
	private void createUnDirecedGraph() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {				// 初始化邻接矩阵，在每个位置都放上0
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = 0;							
			}
		}
		System.out.println("请输入各个边的两个顶点: ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应位置上的1
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = 1;		
		}
	}
	
	// 创建有向图
	private void createDirectedGraph() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {				// 初始化邻接矩阵，在每个位置都放上0
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = 0;
			}
		}
		System.out.println("请输入各个边的两个顶点: ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = 1;								
		}
	}
	
	// 创建无向网
	private void createUnDirectedNet() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {				// 初始化邻接矩阵，在每个位置都放上正无穷
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = INFINITY;
				arcs[u][u] = 0;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值: ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = sc.nextInt();		// 由于无向网是矩阵对称的，所以在对称的位置填上对应的值
		}
	}
	
	// 创建有向网
	private void createDirectedNet() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++) {				// 初始化邻接矩阵，在每个位置都放上正无穷
			for (int u = 0; u < vexNum; u++) {
				arcs[v][u] = INFINITY;
				arcs[u][u] = 0;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值: ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = sc.nextInt();					// 有向网不对称
		}
	}

	// 返回v表示结点的值
	public Object getVex(int x) throws Exception{
		if (x < 0 && x >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		return vexs[x];
	}

	// 返回顶点的值为vex的顶点在顶点数组的位置下标，如果图中不包含值为vex的顶点，则返回-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++) {
			if (vexs[v].equals(vex)) {
				return v;
			}
		}
		return -1;
	}

	// 返回下标为v的顶点的第一个邻接点，即遍历邻接矩阵的第v行,找到之后，返回第v行对应的下标
	public int firstAdjvex(int v) throws Exception {
		if (v < 0 && v >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		for (int j = 0; j < vexNum; j++) {
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY) {
				return j;
			}
		}
		return -1;
	}

	// 返回下标为v的顶点相对于下标为w的顶点的下一个邻接点，若w是v的最后一个邻接点，则返回-1
	public int nextAdjvex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		for (int j = w + 1; j < vexNum; j++) {
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY) {
				return j;
			}
		}
		return -1;
	}
	
	// 手动创建一个用于测试图的遍历算法的无向图
	public static AdjacencyMatrixGraphINF createUDGByYourHand_ForSearch() {
		Object vexs_UDG[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		int arcsNum_UDG = 14;
		int[][] arcs_UDG = new int[vexs_UDG.length][vexs_UDG.length];	
		for (int i = 0; i < vexs_UDG.length; i++) 		// 构造无向图邻接矩阵
			for (int j = 0; j < vexs_UDG.length; j++) 
				arcs_UDG[i][j] = 0;
		arcs_UDG[0][1] = 1;
		arcs_UDG[0][5] = 1;
		arcs_UDG[1][2] = 1;
		arcs_UDG[1][6] = 1;
		arcs_UDG[1][8] = 1;
		arcs_UDG[2][3] = 1;
		arcs_UDG[2][8] = 1;
		arcs_UDG[3][4] = 1;
		arcs_UDG[3][6] = 1;
		arcs_UDG[3][7] = 1;
		arcs_UDG[3][8] = 1;
		arcs_UDG[4][5] = 1;
		arcs_UDG[4][7] = 1;
		arcs_UDG[5][6] = 1;
		for (int i = 0; i < vexs_UDG.length; i++) 		// 构造无向图邻接矩阵
			for (int j = i; j < vexs_UDG.length; j++) 
				arcs_UDG[j][i] = arcs_UDG[i][j];
		return new AdjMatGraph(GraphKind.UDG, vexs_UDG.length, arcsNum_UDG, vexs_UDG, arcs_UDG);
	}
	
	// 手动创建一个用于测试最小生成树算法的无向网
	public static AdjacencyMatrixGraphINF createUDNByYourHand_ForMiniSpanTree() {
		Object vexs_UDN[] = {"V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
		int arcsNum_UDN = 15;
		int[][] arcs_UDN = new int[vexs_UDN.length][vexs_UDN.length];	
		for (int i = 0; i < vexs_UDN.length; i++) 		// 构造无向图邻接矩阵
			for (int j = 0; j < vexs_UDN.length; j++) 
				if (i==j) {
					arcs_UDN[i][j]=0;
				} else {
					arcs_UDN[i][j] = arcs_UDN[i][j] = INFINITY;
				}
		
		arcs_UDN[0][1] = 10;
		arcs_UDN[0][5] = 11;
		arcs_UDN[1][2] = 18;
		arcs_UDN[1][6] = 16;
		arcs_UDN[1][8] = 12;
		arcs_UDN[2][3] = 22;
		arcs_UDN[2][8] = 8;
		arcs_UDN[3][4] = 20;
		arcs_UDN[3][6] = 24;
		arcs_UDN[3][7] = 16;
		arcs_UDN[3][8] = 21;
		arcs_UDN[4][5] = 26;
		arcs_UDN[4][7] = 7;
		arcs_UDN[5][6] = 17;
		arcs_UDN[6][7] = 19;
		
		for (int i = 0; i < vexs_UDN.length; i++) 		// 构造无向图邻接矩阵
			for (int j = i; j < vexs_UDN.length; j++) 
				arcs_UDN[j][i] = arcs_UDN[i][j];
		return new AdjMatGraph(GraphKind.UDN, vexs_UDN.length, arcsNum_UDN, vexs_UDN, arcs_UDN);
	}
	
	// 手动创建一个用于测试最短路径算法的无向网
	public static AdjacencyMatrixGraphINF createUDNByYourHand_ForTheShortestPath() {
		Object vexs_UDN[] = {"V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
		int arcsNum_UDN = 16;
		int[][] arcs_UDN = new int[vexs_UDN.length][vexs_UDN.length];	
		for (int i = 0; i < vexs_UDN.length; i++) 		// 构造无向图邻接矩阵
			for (int j = 0; j < vexs_UDN.length; j++) 
				if (i==j) {
					arcs_UDN[i][j]=0;
				} else {
					arcs_UDN[i][j] = arcs_UDN[i][j] = INFINITY;
				}
		
		arcs_UDN[0][1] = 1;
		arcs_UDN[0][2] = 5;
		arcs_UDN[1][2] = 3;
		arcs_UDN[1][3] = 7;
		arcs_UDN[1][4] = 5;
		arcs_UDN[2][4] = 1;
		arcs_UDN[2][5] = 7;
		arcs_UDN[3][4] = 2;
		arcs_UDN[3][6] = 3;
		arcs_UDN[4][5] = 3;
		arcs_UDN[4][6] = 6;
		arcs_UDN[4][7] = 9;
		arcs_UDN[5][7] = 5;
		arcs_UDN[6][7] = 2;
		arcs_UDN[6][8] = 7;
		arcs_UDN[7][8] = 4;
		
		for (int i = 0; i < vexs_UDN.length; i++) 		// 构造无向图邻接矩阵
			for (int j = i; j < vexs_UDN.length; j++) 
				arcs_UDN[j][i] = arcs_UDN[i][j];
		return new AdjMatGraph(GraphKind.UDN, vexs_UDN.length, arcsNum_UDN, vexs_UDN, arcs_UDN);
	}


	public static void main(String[] args) throws Exception {
//		AdjMatGraph aMatGraph = new AdjMatGraph();
//		aMatGraph.createGraph();
//		System.out.println("该类型的图已经创建完成！");
//		System.out.println("顶点2的第一个邻接点是: " + aMatGraph.firstAdjvex(2));
//		System.out.println("顶点2的相对于顶点0的下一个邻接点是: " + aMatGraph.nextAdjvex(2, 0));
//		AdjMatGraph UDG_Graph = (AdjMatGraph) createUDGByYourHand_ForSearch();
//		Depth_First_Search.DFSTraverse(DNG_Graph);
//		Breadth_First_Search.BFSTraverse(DNG_Graph);
//		AdjMatGraph UDN_Graph = (AdjMatGraph) createUDNByYourHand_ForMiniSpanTree();
//		MiniSpanTree_Prim.Prim(UDN_Graph, "V0");
//		MiniSpanTree_Kruskal.Kruskal(UDN_Graph);
		AdjMatGraph UDN_Graph_TSP = (AdjMatGraph) createUDNByYourHand_ForTheShortestPath();
//		TheShortestPath_Dijkstra.Dijkstra(UDN_Graph_TSP, "V0");
		TheShortestPath_Floyd.Floyd(UDN_Graph_TSP);
	}
}
