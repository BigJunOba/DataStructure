package bigjun.iplab.internalSort;

public class MergeSort {

	private static void merge(int[] a, int[] swap, int k) {
		int n = a.length;
		int m = 0, i, j;
		
		int end1, start2, end2;
		int start1 = 0;													// 第一个有序子数组下界
		
		while (start1 + k <= n - 1) {
			start2 = start1 + k;										// 第二个有序子数组下界
			end1 = start2 - 1;											// 第一个有序子数组上界
			end2 = (start2 + k - 1 <= n - 1)? start2 + k - 1 : n - 1;	// 第二个有序子数组上界
			
			for (i = start1, j = start2; i <= end1 && j <= end2; m++) { // 将k-1个数从小到大排列并写入swap数组
				if (a[i] <= a[j]) {
					swap[m] = a[i];
					i++;
				} else {
					swap[m] = a[j];
					j++;
				}
			}
			
			while (i <= end1) {		// 如果i越界就把k个数中值最大的放在swap数组的区间数组最后一位							
				swap[m] = a[i];
				m++;
				i++;
			}
			
			while (j <= end2) {		// 如果j越界就把k个数中值最大的放在swap数组的区间数组最后一位
				swap[m] = a[j];
				m++;
				j++;
			}
			
			start1 = end2 + 1;		// 从下一个k区间的第一个数开始
		}
		
		for (i = start1; i < n; i++, m++) {	// 将原始数组中只够一组的数据元素顺序存放到数组swap中
			swap[m] = a[i];
		}
	}
	
	public static void mergeSort(int[] a) {
		int k = 1;									// 归并长度从1开始
		int[] swap = new int[a.length];
		
		while (k < a.length) {
			merge(a, swap, k);
			
			for (int i = 0; i < a.length; i++) {	// 将调整后的元素重新放回原始数组中
				a[i] = swap[i];		
			}
			System.out.print("k值为" + k + "时: ");
			print(a);
			
			k = 2 * k;								// 归并长度为原来的二倍
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
		System.out.print("归并排序前: ");
		print(array1);
		mergeSort(array1);
		System.out.print("归并排序后: ");
		print(array1);
		
	}
	
}
