package bigjun.iplab.adjacencyMatrix;

import bigjun.iplab.linkQueue.LinkQueue;
/**
 * 图的遍历之广度优先遍历算法
 */
public class Breadth_First_Search {
	
	private static boolean[] visited;
	
	public static void BFSTraverse(AdjacencyMatrixGraphINF G) throws Exception{
		System.out.print("图的广度优先遍历序列为: ");
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++) 			// 访问标志数组初始化都为false，即未访问过
			visited[v] = false;						
		for (int v = 0; v < G.getVexNum(); v++) 			// 如果没有访问过就对顶点调用深度优先遍历算法
			if (!visited[v]) 
				BFS(G, v);
		System.out.println();
	}

	private static void BFS(AdjacencyMatrixGraphINF G, int v) throws Exception {
		visited[v] = true;									// 先将访问标识数组置为true
		System.out.print(G.getVex(v).toString() + " ");		// 然后访问对应数组下标的顶点
		LinkQueue queue = new LinkQueue();					// 链队列初始化
		queue.queueEnter(v);								// 将访问过的顶点的数组下标入队列
		while (!queue.isqueueEmpty()) {
			int u = (Integer) queue.queuePoll();			// 队列队头元素出队列并赋值给u
			for (int w = G.firstAdjvex(u); w >= 0; w = G.nextAdjvex(u, w)) {
				if (!visited[w]) {
					visited[w] = true;
					System.out.print(G.getVex(w).toString() + " ");
					queue.queueEnter(w);
				}
			}
		}
	}

}

