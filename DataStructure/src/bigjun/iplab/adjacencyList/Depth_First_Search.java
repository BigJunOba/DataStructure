package bigjun.iplab.adjacencyList;

public class Depth_First_Search {
	
	private static boolean[] visited;				// 访问标识数组
	
	public static void DFSTraverse(AdjacencyListGraphINF G) throws Exception{
		System.out.print("图的深度优先遍历序列为: ");
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++) 	// 访问标志数组初始化都为false，即未访问过
			visited[v] = false;						
		for (int v = 0; v < G.getVexNum(); v++) 	// 如果没有访问过就对顶点调用深度优先遍历算法
			if (!visited[v]) 
				DFS(G, v);
		System.out.println();
	}

	private static void DFS(AdjacencyListGraphINF G, int v) throws Exception {
		visited[v] = true;							// 先将访问标识数组置为true
		System.out.print(G.getVex(v).toString() + " ");
		for (int w = G.firstAdjvex(v); w >= 0; w = G.nextAdjvex(v, w)) 
			if (!visited[w]) 
				DFS(G, w);
	}
	
}

