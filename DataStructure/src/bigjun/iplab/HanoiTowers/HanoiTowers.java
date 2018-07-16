package bigjun.iplab.HanoiTowers;

public class HanoiTowers {

	public static void hTowers(int n, char form, char to, char via) {
		
		// 递归出口，n=1只有一个盘子时，直接从A移到C
		if (n == 1) {
			System.out.println("移动盘子1从" + form + "到" + to);
			return;
		}
		
		// 将n-1个盘子从A借助C移到B
		hTowers(n - 1, form, via, to);
		
		System.out.println("移动盘子" + n + "从" + form + "到" + to);
		
		// 将n-1个盘子从B借助A移到C
		hTowers(n - 1, via, to, form);
	}
	
	
	public static void main(String[] args) {
		// 将4个盘子从A借助B移到C
		hTowers(4, 'A', 'C', 'B');
	}
}
