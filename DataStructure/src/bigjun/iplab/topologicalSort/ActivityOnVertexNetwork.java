package bigjun.iplab.topologicalSort;

public class ActivityOnVertexNetwork {

	public int vexNum, edgeNum;		// 顶点数，边数
	public VertexNode[] vexs;			// 顶点结点组成的顶点数组
	

	// 构造方法1: 构造一个空图
	public ActivityOnVertexNetwork() {
		this(0, 0, null);
	}
	
	// 构造方法2: 构造一个非空图
	public ActivityOnVertexNetwork(int vexNum, int edgeNum, VertexNode[] vexs) {
		this.vexNum = vexNum;
		this.edgeNum = edgeNum;
		this.vexs = vexs;
	}
	
	
	public int getVexNum() {
		return vexNum;
	}

	public int getEdgeNum() {
		return edgeNum;
	}

	public VertexNode[] getVexs() {
		return vexs;
	}
	
	public Object getVex(int x) {
		return vexs[x].data;
	}

	public static ActivityOnVertexNetwork createDN_ForTopologicalSort() {
		
		EdgeNode e_0_4 = new EdgeNode(4);
		EdgeNode e_0_5 = new EdgeNode(5, e_0_4);
		EdgeNode e_0_11 = new EdgeNode(11, e_0_5);
		VertexNode v0 = new VertexNode(0, "V0", e_0_11);
		
		EdgeNode e_1_2 = new EdgeNode(2);
		EdgeNode e_1_4 = new EdgeNode(4, e_1_2);
		EdgeNode e_1_8 = new EdgeNode(8, e_1_4);
		VertexNode v1 = new VertexNode(0, "V1", e_1_8);
		
		EdgeNode e_2_5 = new EdgeNode(5);
		EdgeNode e_2_6 = new EdgeNode(6, e_2_5);
		EdgeNode e_2_9 = new EdgeNode(9, e_2_6);
		VertexNode v2 = new VertexNode(2, "V2", e_2_9);
		
		EdgeNode e_3_2 = new EdgeNode(2);
		EdgeNode e_3_13 = new EdgeNode(13, e_3_2);
		VertexNode v3 = new VertexNode(0, "V3", e_3_13);
		
		EdgeNode e_4_7 = new EdgeNode(7);
		VertexNode v4 = new VertexNode(2, "V4", e_4_7);
		
		EdgeNode e_5_12 = new EdgeNode(12);
		EdgeNode e_5_8 = new EdgeNode(8, e_5_12);
		VertexNode v5 = new VertexNode(3, "V5", e_5_8);
		
		EdgeNode e_6_5 = new EdgeNode(5);
		VertexNode v6 = new VertexNode(1, "V6", e_6_5);
		
		VertexNode v7 = new VertexNode(2, "V7");
		
		EdgeNode e_8_7 = new EdgeNode(7);
		VertexNode v8 = new VertexNode(2, "V8", e_8_7);
		
		EdgeNode e_9_11 = new EdgeNode(11);
		EdgeNode e_9_10 = new EdgeNode(10, e_9_11);
		VertexNode v9 = new VertexNode(1, "V9", e_9_10);
		
		EdgeNode e_10_13 = new EdgeNode(13);
		VertexNode v10 = new VertexNode(1, "V10", e_10_13);
		
		VertexNode v11 = new VertexNode(2, "V11");
		
		EdgeNode e_12_9 = new EdgeNode(12);
		VertexNode v12 = new VertexNode(1, "V12", e_12_9);
		
		VertexNode v13 = new VertexNode(2, "V13");
		
		VertexNode[] vexs = {v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13};
		
		int vertexNum = vexs.length;
		int edgeNum = 20;
		
		return new ActivityOnVertexNetwork(vertexNum, edgeNum, vexs);
		
	}
	
	public static void main(String[] args) throws Exception {
		ActivityOnVertexNetwork DN_ForTopoSort = createDN_ForTopologicalSort();
		TopologicalSort.TopoSort(DN_ForTopoSort);
	}
}
