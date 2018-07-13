package bigjun.iplab.internalSort;

public class ShellSort {

	public static void shellSort(int[] L, int[] d) {
		int i, j, k, m, span;
		int temp;
		for (m= 0; m < d.length; m++) {
			span = d[m];
			for (k = 0; k < span; k++) {
				/********将i=0换成i=k，1换成span的直接插入排序**********/
				for (i = k; i < L.length - span; i = i + span) { 
					temp = L[i+span];
					j = i;
					while (j > -1 && temp <= L[j]) {
						L[j + span] = L[j];
						j = j - span;
					}
					L[j + span] = temp;
					print(L);
				}
				/***********************************************/
			}
			System.out.print("span的值为" + span + "时得到的序列为: ");
			print(L);
		}
	}
	
	public static void print(int[] L) {
		for (int i = 0; i < L.length; i++) {
			System.out.print(L[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] array1 = {9,1,5,8,3,7,4,6,2};
		System.out.print("希尔排序前: ");
		print(array1);
		int[] d = {4,2,1};
		shellSort(array1, d);
		System.out.print("希尔排序后: ");
		print(array1);
	}
	
}
