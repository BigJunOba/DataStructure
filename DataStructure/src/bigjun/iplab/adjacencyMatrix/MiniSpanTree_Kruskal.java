package bigjun.iplab.adjacencyMatrix;
/**
 * 最小生成树之Kruskal算法
 */
public class MiniSpanTree_Kruskal {
	
	private final static int INFINITY = Integer.MAX_VALUE;	// 表示正无穷
	
	private static class Edge{
		int begin;		// 边的起点
		int weight;		// 边的权值
		int end;		// 边的终点
		
		public Edge(int begin, int weight, int end) {
			this.begin = begin;
			this.weight = weight;
			this.end = end;
		}
	}

	// 交换两条边的各个属性，包括起点，终点和权值
	private static void Swap_edges(Edge[] edges, int i, int j) {
		int temp;
		temp = edges[i].begin;
		edges[i].begin = edges[j].begin;
		edges[j].begin = temp;
		temp = edges[i].weight;
		edges[i].weight = edges[j].weight;
		edges[j].weight = temp;
		temp = edges[i].end;
		edges[i].end = edges[j].end;
		edges[j].end = temp;
	}
	
	// 对边集数组按照权值进行排序
	private static void Sorted_Edge(Edge[] edges) {
		for (int i = 0; i < edges.length; i++) {
			for (int j = i + 1; j < edges.length; j++) {
				if (edges[i].weight > edges[j].weight) {
					Swap_edges(edges, i, j);
				}
			}
		}
		
	}
	
	// 查找顶点的尾部下标
	private static int Find_indexOfParent(int[] parent, int f) {
		while (parent[f] > 0) {
			f = parent[f];
		}
		return f;
	}
	
	public static void Kruskal(AdjacencyMatrixGraphINF G) throws Exception {
		Edge[] edges = new Edge[G.getArcNum()];	// 定义边集数组
		int[] parent = new int[G.getVexNum()];	// 定义一组数组用来判断边与边是否形成回路
		int k = 0;
		for (int i = 0; i < G.getVexNum() - 1; i++) {	// 将邻接矩阵G转化为边集数组edges
			for (int j = i + 1; j < G.getVexNum(); j++) {
				if (G.getArcs()[i][j] < INFINITY) {
					edges[k] = new Edge(i, G.getArcs()[i][j], j);
					k++;
				}
			}
		}
		Sorted_Edge(edges);							// 对边集数组按照权值从小到大排序
		for (int i = 0; i < G.getVexNum(); i++) {	// 初始化判断边与边是否形成回路数组
			parent[i] = 0;
		}
		System.out.print("通过Kruskal算法得到的最小生成树序列为: {");
		for (int i = 0; i < edges.length; i++) {	// 遍历每一条边
			int n = Find_indexOfParent(parent, edges[i].begin);
			int m = Find_indexOfParent(parent, edges[i].end);
			if (n!=m) {								// 如果不构成回路的话
				parent[n] = m;						// 将此边的结尾项放在下标为起点的parent中，表示此顶点已经在生成树集合中
				System.out.print("(" + G.getVex(edges[i].begin) + "-" + G.getVex(edges[i].end) + ")");
			}
		}
		System.out.println("}");
	}
}
