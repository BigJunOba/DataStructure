package bigjun.iplab.internalSort;

public class SimpleSelectionSort {

	public static void simpleSelectionSort(int[] L) {
		for (int i = 0; i < L.length; i++) {
			int min = i;								// 将当前下标定义为最小值下标
			for (int j = i + 1; j < L.length; j++) {	// 循环之后的数据
				if (L[min] > L[j]) {					// 如果有小于当前最小值的关键字
					min = j;							// 将此关键字的下标赋值给min
				}
			}
			if (i != min) {								// 如果min不等于i，说明找到了最小值
				swap(L, i, min);						// 此时才交换
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
		System.out.print("简单选择排序前: ");
		print(array1);
		simpleSelectionSort(array1);
		System.out.print("简单选择排序后: ");
		print(array1);
		
	}
	
}
