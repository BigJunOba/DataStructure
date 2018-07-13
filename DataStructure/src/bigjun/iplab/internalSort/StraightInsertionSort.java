package bigjun.iplab.internalSort;

public class StraightInsertionSort {

	public static void straightInsertionSort(int[] L) {
		int i, j, temp;
		for (i = 0; i < L.length - 1; i++) {	
			temp = L[i+1];						// 保存要插入的数据元素
			j = i;								
			while (j > -1 && temp <= L[j]) {	// 将temp插入到原数组集合中
				L[j+1] = L[j];
				j--;
			}
			L[j+1] = temp;						 
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
		System.out.print("简单选择排序前: ");
		print(array1);
		straightInsertionSort(array1);
		System.out.print("简单选择排序后: ");
		print(array1);
		
	}
}
