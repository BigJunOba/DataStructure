package bigjun.iplab.adjacencyMatrix;
/**
 * 最小生成树之Prim算法
 */
public class MiniSpanTree_Prim {

	private static class CloseEdge{
		Object adjVex;				// 顶点符号
		int lowCost;				// 顶点对应的权值
		public CloseEdge(Object adjVex, int lowCost) {
			this.adjVex = adjVex;
			this.lowCost = lowCost;
		}
	}
	
	private static int getMinMum(CloseEdge[] closeEdges) {
		int min = Integer.MAX_VALUE;		// 初始化最小权值为正无穷
		int v = -1;							// 顶点数组下标
		for (int i = 0; i < closeEdges.length; i++) {	// 遍历权值数组，找到最小的权值以及对应的顶点数组的下标
			if (closeEdges[i].lowCost != 0 && closeEdges[i].lowCost < min) {
				min = closeEdges[i].lowCost;
				v = i;
			}
		}
		return v;
	}
	
	// Prim算法构造图G的以u为起始点的最小生成树
	public static void Prim(AdjacencyMatrixGraphINF G, Object u) throws Exception{
		// 初始化一个二维最小生成树数组minSpanTree，由于最小生成树的边是n-1，所以数组第一个参数是G.getVexNum() - 1，第二个参数表示边的起点和终点符号，所以是2
		Object[][] minSpanTree = new Object[G.getVexNum() - 1][2];
		int count = 0;												// 最小生成树得到的边的序号
		// 初始化保存相关顶点和相关顶点间边的权值的数组对象
		CloseEdge[] closeEdges = new CloseEdge[G.getVexNum()];
		int k = G.locateVex(u);
		for (int j = 0; j < G.getVexNum(); j++) {
			if (j!=k) {
				closeEdges[j] = new CloseEdge(u, G.getArcs()[k][j]);// 将顶点u到其他各个顶点权值写入数组中
			}
		}
		closeEdges[k] = new CloseEdge(u, 0);						// 加入u到自身的权值0
		for (int i = 1; i < G.getVexNum(); i++) {					// 注意，这里从1开始，
			k = getMinMum(closeEdges);								// 获取u到数组下标为k的顶点的权值最短
			minSpanTree[count][0] = closeEdges[k].adjVex;			// 最小生成树第一个值为u
			minSpanTree[count][1] = G.getVexs()[k];					// 最小生成树第二个值为k对应的顶点
			count++;
			closeEdges[k].lowCost = 0;								// 下标为k的顶点不参与最小权值的查找了
			for (int j = 0; j < G.getVexNum(); j++) {
				if (G.getArcs()[k][j] < closeEdges[j].lowCost) {
					closeEdges[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
				}
			}
		}
		System.out.print("通过Prim算法得到的最小生成树序列为: {");
		for (Object[] Tree : minSpanTree) {
			System.out.print("(" + Tree[0].toString() + "-" + Tree[1].toString() + ")");
		}
		System.out.println("}");
	}
	
}
