package bigjun.iplab.criticalPath;

public class ActivityOnEdgeNetwork {

	public int vexNum, edgeNum;		// 顶点数，边数
	public VertexNode[] vexs;			// 顶点结点组成的顶点数组
	

	// 构造方法1: 构造一个空图
	public ActivityOnEdgeNetwork() {
		this(0, 0, null);
	}
	
	// 构造方法2: 构造一个非空图
	public ActivityOnEdgeNetwork(int vexNum, int edgeNum, VertexNode[] vexs) {
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

	public static ActivityOnEdgeNetwork createDN_ForTheCriticalPath() {
		
		EdgeNode e_0_1 = new EdgeNode(1, 3);
		EdgeNode e_0_2 = new EdgeNode(2, 4, e_0_1);
		VertexNode v0 = new VertexNode(0, "V0", e_0_2);
		
		EdgeNode e_1_3 = new EdgeNode(3, 5);
		EdgeNode e_1_4 = new EdgeNode(4, 6, e_1_3);
		VertexNode v1 = new VertexNode(1, "V1", e_1_4);
		
		EdgeNode e_2_3 = new EdgeNode(3, 8);
		EdgeNode e_2_5 = new EdgeNode(5, 7, e_2_3);
		VertexNode v2 = new VertexNode(1, "V2", e_2_5);
		
		EdgeNode e_3_4 = new EdgeNode(4, 3);
		VertexNode v3 = new VertexNode(2, "V3", e_3_4);
		
		EdgeNode e_4_6 = new EdgeNode(6, 9);
		EdgeNode e_4_7 = new EdgeNode(7, 4, e_4_6);
		VertexNode v4 = new VertexNode(2, "V4", e_4_7);
		
		EdgeNode e_5_7 = new EdgeNode(7, 6);
		VertexNode v5 = new VertexNode(1, "V5", e_5_7);
		
		EdgeNode e_6_9 = new EdgeNode(9, 2);
		VertexNode v6 = new VertexNode(1, "V6", e_6_9);
		
		EdgeNode e_7_8 = new EdgeNode(8, 5);
		VertexNode v7 = new VertexNode(2, "V7", e_7_8);
		
		EdgeNode e_8_9 = new EdgeNode(9, 3);
		VertexNode v8 = new VertexNode(1, "V8", e_8_9);
		
		VertexNode v9 = new VertexNode(2, "V9");
		
		VertexNode[] vexs = {v0,v1,v2,v3,v4,v5,v6,v7,v8,v9};
		
		int vertexNum = vexs.length;
		int edgeNum = 13;
		
		return new ActivityOnEdgeNetwork(vertexNum, edgeNum, vexs);
		
	}
	
	public static void main(String[] args) throws Exception {
		ActivityOnEdgeNetwork DN_ForCriticalPath = createDN_ForTheCriticalPath();
		TheCriticalPath.CriticalPath(DN_ForCriticalPath);
	}
}
