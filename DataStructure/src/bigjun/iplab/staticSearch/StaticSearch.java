package bigjun.iplab.staticSearch;

public class StaticSearch {

	private static final int MAXSIZE = 100;		// 存储空间初始分配量
	
	// 顺序查找，a为数组，key为要查找的关键字，查找成功则返回i，否则返回-1
	private static int seqSearch(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	// 有哨兵顺序查找数组a中从a[1]到数组末尾的key，无哨兵每次循环都需要对i是否越界，即是否小于a.length做判断。
	// 设置一个哨兵可以解决不需要每次让i与a.length作比较。
	// 返回-1说明查找失败，注意: 只能从数组下标为1的位置开始查找
	private static int seqSearchWithGuard(int[] a, int key) {
		int i = a.length - 1;	// 设置循环从数组尾部开始
		a[0] = key;				// 设置a[0]为关键字值，称之为"哨兵"
		while (a[i] != key) {
			i--;
		}
		if (i>0) {
			return i;
		} else {
			return -1;
		}
	}
	
	// 二分查找:数组a中所有数据中包含key的数组下标，如果没有，返回-1
	private static int binarySearch(int[] a, int key) {
		int low = 0;  						// 定义最低下标为记录首位
		int high = a.length-1;				// 定义最高下标为记录末位
		while (low<=high) {
			int mid = (low + high)/2;		// 折半得到中间记录的下标
			if (key < a[mid]) {				// 若查找值比中值小
				high = mid - 1;				// 最高下标调整到中间下标小一位
			} else if (key > a[mid]) {		// 若查找值比中指大
				low = mid + 1;				// 最低下标调整到中间下标大一位
			} else {
				return mid;					// 若相等则说明中间记录的下标即为查找到的值
			}
		}
		return -1;
	}
	
	// 插值查找:数组a中所有数据中包含key的数组下标，如果没有，返回-1
	private static int interpolationSearch(int[] a, int key) {
		int low = 0;  						// 定义最低下标为记录首位
		int high = a.length-1;				// 定义最高下标为记录末位
		while (low<=high) {
			int mid = low + (high-low)*(key-a[low])/(a[high]-a[low]);// 插值计算公式
			if (key < a[mid]) {				// 若查找值比中值小
				high = mid - 1;				// 最高下标调整到中间下标小一位
			} else if (key > a[mid]) {		// 若查找值比中指大
				low = mid + 1;				// 最低下标调整到中间下标大一位
			} else {
				return mid;					// 若相等则说明中间记录的下标即为查找到的值
			}
		}
		return -1;
	}
	
	private static int FibonacciSearch(int[] a, int key) {
		// 创建一个斐波那契数列的数组
		int[] F = new int[100];		// 斐波那契数列
		F[0]=0;
		F[1]=1;
		for (int i = 2; i < F.length; i++) {
			F[i] = F[i-1] + F[i-2];
		}
		// 斐波那契算法准备工作
		int low = 0;  									// 定义最低下标为记录首位
		int high = a.length-1;							// 定义最高下标为记录末位
		int k = 0;
		int[] a_temp = new int[F.length];
		System.arraycopy(a, 0, a_temp, 0, a.length);	// 将数组a复制到a_temp数组中，因为要保证a_temp的长度和F数组长度一致
		while (a.length - 1 > F[k] - 1) {				// 计算要查找的最大下标位于斐波那契数列中的位置
			k++;
		}
		for (int i = a.length -1; i < F[k] - 1; i++) {	// 将不满的数值补全
			a_temp[i] = a_temp[a.length - 1];
		}
		// 斐波那契算法开始，可以结合二分查找算法对比着理解
		while (low<=high) {
			int mid = low + F[k-1] - 1;		// 计算当前分隔的下标
			if (key < a_temp[mid]) {		// 若查找值比中值小
				high = mid - 1;				// 最高下标调整到中间下标小一位
				k = k - 1;					// 斐波那契数下标减一位
			} else if (key > a_temp[mid]) {	// 若查找值比中指大
				low = mid + 1;				// 最低下标调整到中间下标大一位
				k = k - 2;					// 斐波那契数下标减二位
			} else {
				if (mid <= a.length - 1) {	// 若相等或小于数组下标最大值则说明mid即为查找到的位置
					return mid;
				} else {					// 若min>数组下标最大值则说明是补全值，返回数组中最后一位
					return a.length - 1;
				}
			}
		}
		return -1;
	}
	
	private static int[] createArray() {
		int[] a = new int[MAXSIZE + 1];
		for (int i = 0; i <= MAXSIZE; i++) {
			a[i] = i;
		}
		return a;
	}
	
	public static void main(String[] args) {

		int[] a = createArray();
		System.out.println("创建了一个数组长度为" + a.length + ",a[0]=" + a[0] + ",a[100]=" + a[100] + "的数组" );
		System.out.println("顺序查找100: " + seqSearch(a, MAXSIZE));
		System.out.println("顺序查找0: " + seqSearch(a, 0));
		System.out.println("带监视哨的顺序查找0: " +seqSearchWithGuard(a, 0));
		System.out.println("带监视哨的顺序查找1: " +seqSearchWithGuard(a, 1));
		
		int[] array = {0,1,16,24,35,47,59,62,73,88,99};
		System.out.println("二分查找62: " +binarySearch(array, 62));
		System.out.println("插值查找62: " +interpolationSearch(array, 62));
		System.out.println("斐波那契查找62: " +FibonacciSearch(array, 62));
		System.out.println("斐波那契查找99: " +FibonacciSearch(array, 99));
		System.out.println("斐波那契查找0: " +FibonacciSearch(array, 0));
		System.out.println("斐波那契查找100: " +FibonacciSearch(array, 100));
	}
}
