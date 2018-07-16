package bigjun.iplab.addOfLargeNum;

public class AdditionOfLargeNumbers {

	public String addOfLargeNum(String a, String b) throws Exception {
		LinkStack sum = new LinkStack();  			// 大数的和
		LinkStack sA = numSplit(a);					// 加数字符串以单个字符的形式放入栈中
		sA.stackTraverse();
		LinkStack sB = numSplit(b);					// 被加数字符串以单个字符的形式放入栈中
		sB.stackTraverse();
		int partialSum;								// 对应位置的两个数相加
		boolean isCarry = false;					// 是否仅为标识
		while (!sA.isEmpty() && !sB.isEmpty()) {	// 两个栈都不为空
			partialSum = (Integer) sA.Pop() + (Integer)sB.Pop();	// 将两个栈的栈顶元素即大数的个位相加
			if (isCarry) {				// 判断低位是否有进位
				partialSum++;			// 如果有进位就加1
				isCarry = false;		// 重置进位标识
			}
			if (partialSum >= 10) {		// 如果超过了10就需要进位
				partialSum -= 10;		// 取个位数字
				sum.Push(partialSum);	// 将得到的加和入大数的和栈
				isCarry = true;			// 将进位标志位置为true
			} else {
				sum.Push(partialSum);	// 不需要进位时直接放入栈中
			}
		}
		LinkStack temp = !sA.isEmpty()? sA : sB;	// 如果有一个加数比另一个加数短，则取长的那个加数加完剩下的栈
		while (!temp.isEmpty()) {					
			if (isCarry) {							// 最后一次执行加法运算中需要进位
				int t = (Integer)temp.Pop();		// 取出没有参加加法的位
				t++;								// 加上进位位1
				if (t >= 10) {						// 如果超过10，就需要进位
					t -= 10;
					sum.Push(t);					// 这里没有改变进位标识isCarry，下一次还是true
				} else {
					sum.Push(t);					// 不需要进位时直接入和栈
					isCarry = false;				
				}
			} else {
				sum.Push(temp.Pop());
			}
		}
		if (isCarry) {		// 最高一位入栈后仍然需要进位的情况
			sum.Push(1);	// 再最高位的前一位入栈
		}
		String str = new String();
		while (!sum.isEmpty()) {	// 将栈中的数按正常顺序转化为字符串输出
			str = str.concat(sum.Pop().toString());
		}
		return str;
	}
	
	// 将字符串以单个字符的形式放入栈中，并去除字符串中的空格，返回以单个字符为元素的栈
	private LinkStack numSplit(String str) throws Exception {
		LinkStack s = new LinkStack();
		for (int i = 0; i < str.length(); i++) {		
			char c = str.charAt(i);						
			if (c == ' ') {										// 去除空格
				continue;	
			} else if ('0' <= c && c <= '9') {					// 判断是不是0到9之间的数
				s.Push(Integer.valueOf(String.valueOf(c)));		// 如果是，就将数字入栈
			} else {
				throw new Exception("输入了非法数字型字符");
			}
		}
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		AdditionOfLargeNumbers add = new AdditionOfLargeNumbers();
		String largeNum1 = "18 452 453 389 943 209 752 345 473";
		String largeNum2 = "8 123 542 678 432 986 899 334";
		System.out.println("两个大数相加得到的和为: " + add.addOfLargeNum(largeNum1, largeNum2));
		System.out.print("\n");
		System.out.println("两个大数相加得到的和为: " + add.addOfLargeNum("784", "8 465"));
	}
	
}
