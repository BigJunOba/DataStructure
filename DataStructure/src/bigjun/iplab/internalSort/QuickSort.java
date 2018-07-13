package bigjun.iplab.internalSort;

public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {
		int i, j;
		int temp;
		
		i = low;
		j = high;
		temp = a[low];
		
		while (i < j) {	
			while (i < j && temp <= a[j]) {	// 从上限high起，如果大于temp就位置不变
				j--;						// 寻找比temp小的数的数组下标
			}
			if (i < j) {					// 将比temp小的数放在temp坐标的i位置上
				a[i] = a[j];
				i++;
			}
			
			while (i < j && temp > a[i]) { 	// 从下限low起，如果小于temp就位置不变
				i++;						// 寻找比temp大的数的数组下标
			}
			if (i < j) {					// 将比temp的数放在temp坐标的i位置上
				a[j] = a[i];
				j--;
			}
			
		}
		
		a[i] = temp;						// 
		
		if (low < i) {
			quickSort(a, low, i - 1);
		}
		
		if (i < high) {
			quickSort(a, j+1, high);
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
		System.out.print("快速排序前: ");
		print(array1);
		quickSort(array1, 0, array1.length - 1);
		System.out.print("快速排序后: ");
		print(array1);
	}
}
