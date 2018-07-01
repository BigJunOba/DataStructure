package bigjun.iplab.adjacencyList;

import java.util.Scanner;

public class AdjListGraph implements AdjacencyListGraphINF{
	
	private GraphKind kind;			// 图的种类标志
	private int vexNum, arcNum;		// 顶点数，边数
	private VexNode[] vexs;			// 顶点结点组成的顶点数组
	
	public GraphKind getKind() {
		return kind;
	}

	public Object[] getVexs() {
		return vexs;
	}

	// 构造方法1: 构造一个空图
	public AdjListGraph() {
		this(null, 0, 0, null);
	}
	
	// 构造方法2: 构造一个非空图
	public AdjListGraph(GraphKind kind, int vexNum, int arcNum, VexNode[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	// 创建图的四种类型中的一种
	public void createGraph() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入图的类型代号(UDG(无向图)、DG(有向图)、UDN(无向网)、DN(有向网)):");
		GraphKind kind = GraphKind.valueOf(scanner.next());
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
		vexs = new VexNode[vexNum];						// 创建顶点结点数组
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = new VexNode(sc.next());
		}
		System.out.println("请输入各个边的两个顶点(第一个输入是弧尾，第二个输入是弧头): ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());				
			int u = locateVex(sc.next());
			addArc(v, u);						
			addArc(u, v);								// 无向图是双向的弧
		}
	}
	
	// 创建有向图
	private void createDirectedGraph() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VexNode[vexNum];						// 创建顶点结点数组
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = new VexNode(sc.next());
		}
		System.out.println("请输入各个边的两个顶点(第一个输入是弧尾，第二个输入是弧头): ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());				
			int u = locateVex(sc.next());
			addArc(v, u);						
		}
	}
	
	// 创建无向网
	private void createUnDirectedNet() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VexNode[vexNum];						// 创建顶点结点数组
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = new VexNode(sc.next());
		}
		System.out.println("请输入各个边的两个顶点及其权值(第一个输入是弧尾，第二个输入是弧头): ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());				
			int u = locateVex(sc.next());
			int weight = sc.nextInt();					
			addArc(v, u, weight);						
			addArc(u, v, weight);								// 无向网是双向的弧
		}
	}
	
	// 创建有向网
	private void createDirectedNet() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数，图的边数: ");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VexNode[vexNum];						// 创建顶点结点数组
		System.out.println("请分别输入图的各个顶点: ");
		for (int i = 0; i < vexNum; i++) {				// 初始化顶点一维数组
			vexs[i] = new VexNode(sc.next());
		}
		System.out.println("请输入各个边的两个顶点及其权值(第一个输入是弧尾，第二个输入是弧头): ");
		for (int k = 0; k < arcNum; k++) {				// 填入对应的权值
			int v = locateVex(sc.next());				
			int u = locateVex(sc.next());
			int weight = sc.nextInt();					
			addArc(v, u, weight);
		}
	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返回边数
	public int getArcNum() {
		return arcNum;
	}

	// 返回v表示结点的值
	public Object getVex(int x) throws Exception{
		if (x < 0 && x >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		return vexs[x].data;
	}

	// 返回顶点的值为vex的顶点在顶点数组的位置下标，如果图中不包含值为vex的顶点，则返回-1，例如，顶点名称为V0
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++) {
			if (vexs[v].data.equals(vex)) {
				return v;
			}
		}
		return -1;
	}

	// 返回下标为v的顶点的第一个邻接点，即遍历邻接矩阵的第v行,找到之后，返回第v行对应的下标
	public int firstAdjvex(int v) throws Exception {
		if (v < 0 && v >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		VexNode vex = vexs[v];
		if (vex.firstArc != null) {
			return vex.firstArc.adjVex;
		} else {
			return -1;
		}
	}

	// 返回下标为v的顶点相对于下标为w的顶点的下一个邻接点，若w是v的最后一个邻接点，则返回-1
	public int nextAdjvex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum ) 
			throw new Exception("给定的顶点不存在");
		VexNode vex = vexs[v];
		ArcNode arcvTOw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc) {
			if (arc.adjVex == w) {
				arcvTOw = arc;
				break;
			}
		}
		if (arcvTOw != null && arcvTOw.nextArc != null) {
			return arcvTOw.nextArc.adjVex;
		} else {
			return -1;
		}
	}	
	
	// 在位置为v、u的顶点之间，添加一条弧，权值为weight
	public void addArc(int v, int u, int weight) {
		ArcNode arc = new ArcNode(u, weight);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}
	
	// 在位置为v、u的顶点之间，添加一条没有权重的弧
	public void addArc(int v, int u) {
		ArcNode arc = new ArcNode(u);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}
	
	public static void main(String[] args) throws Exception {
		AdjListGraph aListGraph = new AdjListGraph();
		aListGraph.createGraph();
		System.out.println("该类型的图已经创建完成！");
		System.out.println("顶点数组下标为2的第一个邻接点的数组下标是: " + aListGraph.firstAdjvex(2));
		int numOfV2 = aListGraph.firstAdjvex(2);
		System.out.println("顶点V2的第一个邻接点是: " + aListGraph.getVex(numOfV2));
		System.out.println("顶点数组下标为2的相对于顶点数组下标为0的下一个邻接点的数组下标是: " + aListGraph.nextAdjvex(2, 0));
		int numOfV2toV0next = aListGraph.nextAdjvex(2, 0);
		System.out.println("顶点V2相对于V0的邻接点是: " + aListGraph.getVex(numOfV2toV0next));
	}
}
