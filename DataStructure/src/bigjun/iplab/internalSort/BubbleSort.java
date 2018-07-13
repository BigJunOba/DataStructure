package bigjun.iplab.internalSort;

public class BubbleSort {
	
	// 不是标准的冒泡排序算法，因为它不满足"两两比较相邻记录"的冒泡排序思想，是最简单的交换排序而已。
	public static void BubbleSort0(int[] L) {
		for (int i = 0; i < L.length; i++) {
			for (int j = i + 1; j < L.length; j++) {
				if (L[i] > L[j]) {
					swap(L, i, j);
				}
			}
		}
	}
	
	// 标准的冒泡排序算法
	public static void BubbleSort1(int[] L) {
		for (int i = 0; i < L.length; i++) {
			for (int j = L.length - 2; j >= i; j--) {
				if (L[j] > L[j + 1]) {
					swap(L, j, j + 1);
				}
			}
		}
	}
	
	// 改进的冒泡排序算法，增加一个标记变量flag
	public static void BubbleSort2(int[] L) {
		boolean flag = true;	// 用flag来做标记
		for (int i = 0; i < L.length && flag; i++) {
			flag = false;		// 初始值为false
			for (int j = L.length - 2; j >= i; j--) {
				if (L[j] > L[j + 1]) {
					swap(L, j, j + 1);
					flag = true;// 如果有数据交换，则flag为true
				}
			}
		}
	}
	
	public static void swap(int[] L, int i, int j) {
		int temp = L[i];
		L[i] = L[j];
		L[j] = temp;
	}
	
	public static void print(int[] L) {
		for (int i = 0; i < L.length; i++) {
			System.out.print(L[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] array1 = {9,1,5,8,3,7,4,6,2};
		System.out.print("非标准冒泡排序前: ");
		print(array1);
		BubbleSort0(array1);
		System.out.print("非标准冒泡排序后: ");
		print(array1);
		
		int[] array2 = {9,1,5,8,3,7,4,6,2};
		System.out.print("非标准冒泡排序前: ");
		print(array2);
		BubbleSort1(array2);
		System.out.print("非标准冒泡排序后: ");
		print(array2);
		
		int[] array3 = {2,1,3,4,5,6,7,8,9};
		System.out.print("改进的冒泡排序前: ");
		print(array3);
		BubbleSort2(array3);
		System.out.print("改进的冒泡排序后: ");
		print(array3);
	}
	
}
