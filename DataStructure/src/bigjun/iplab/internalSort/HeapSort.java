package bigjun.iplab.internalSort;

public class HeapSort {
	
	private static void createHeap(int[] a, int n, int h) {
		int i ,j, flag;
		int temp;
		i = h;						// i为所有可能的双亲结点下标
		j = 2 * i + 1;				// j为i结点的左孩子结点下标
		temp = a[i];				// temp为调整前双亲结点的值
		flag = 0;
		
		while (j < n && flag != 1) {
			if (j < n - 1 && a[j] < a[j+1]) {// 确定左右孩子结点最大值的数组下标
				j ++;
			}
			if (temp > a[j]) {	// 如果双亲结点的数值大于其左右孩子结点的最大值
				flag = 1;		// 置flag为1，跳出while循环
			} else {			// 如果双亲结点的数值小于其左右孩子结点的最大值
				a[i] = a[j];	// 就令双亲结点的值为其左孩子或者右孩子中值最大的
				i = j;			// 判断调整后的孩子结点与其左右孩子结点关系是否满足
				j = 2 * i + 1;	// j为孩子结点的左孩子结点，同理，再来一遍，确保关系正确
			}
		}
		a[i] = temp;			// 将原来的左右孩子结点的值赋值为双亲结点的值
	}
	
	public static void initCreateHeap(int[] a) {
		int n = a.length;
		for (int i = (n - 1)/2; i >= 0; i--) {	// 遍历有孩子结点的数组下标
			createHeap(a, n, i);
		}
	}
	
	public static void heapSort(int[] a) {
		int temp;
		initCreateHeap(a);							// 初始化创建大顶堆
		for (int i = a.length - 1; i > 0; i--) {	// 当前大顶堆个数依次减1
			temp = a[0];							// 交换堆顶元素和最后一个元素
			a[0] = a[i];
			a[i] = temp;
			createHeap(a, i, 0);					// 将剩余数据元素调整为大顶堆
		}
	}
	
	public static void print(int[] L) {
		for (int i = 0; i < L.length; i++) {
			System.out.print(L[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] array1 = {50,10,90,30,70,40,80,60,20};
		System.out.print("大顶堆创建前: ");
		print(array1);
		initCreateHeap(array1);
		System.out.print("大顶堆创建后: ");
		print(array1);
		
		int[] array2 = {50,10,90,30,70,40,80,60,20};
		System.out.print("堆排序前: ");
		print(array2);
		heapSort(array2);
		System.out.print("堆排序后: ");
		print(array2);
	}
}
