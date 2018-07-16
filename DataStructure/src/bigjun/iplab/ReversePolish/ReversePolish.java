package bigjun.iplab.ReversePolish;
/**
 * 逆波兰表达式(包括将算术表达式转化成逆波兰表达式和计算逆波兰表达式的值)
 */
public class ReversePolish {

	// 将算术表达式转换成后缀表达式
	public String convertToPostfix(String expression){
		LinkStack S = new LinkStack();	// 初始化一个运算符栈
		String postfix = new String();	// 初始化一个用于存放输出的后缀表达式的字符串
		for (int i = 0; i < expression.length() && expression != null; i++) {
			char c = expression.charAt(i);	// 从算数表达式中依次读取字符
			if (c != ' ') {					// 字符c不为空格
				if (isLeftParenthesis(c)) { 									// 字符c为左括号的情况
					S.Push(c);	// 左括号直接入栈
				} else if (isRightParenthesis(c)) {								// 字符c为右括号的情况
					char ac = (Character) S.Pop();
					while (!isLeftParenthesis(ac) && !S.isEmpty()) { // 一直到匹配到左括号为止
						postfix = postfix.concat(String.valueOf(ac));// 将栈中左括号前面的运算符都输出
						ac = (Character) S.Pop();					 // 最后将左括号也弹出栈
					}
				} else if (isOperator(c)) {										// 字符c为运算符的情况
					if (! S.isEmpty()) {
						Object ac = (char) S.Pop();
						// 如果栈顶的运算符的优先级比运算符c的优先级高，则将栈顶元素输出到后缀表达式
						while (ac != null && priority((char) ac) >= priority(c)) { 
							postfix = postfix.concat(String.valueOf(ac));
							ac = S.Pop();
						}
						if (ac != null) { // 将最后一次出栈的优先级没有高于运算符c的优先级的运算符再次入栈
							S.Push(ac);
						}
					} 
					S.Push(c);			// 将字符c入栈
				} else {														// 字符c为数字的情况
					postfix = postfix.concat(String.valueOf(c));	// 直接输出
				}
			}
		}
		while (!S.isEmpty()) {  	// 读取完最后一个字符后，将栈内元素一次出栈输出
			postfix = postfix.concat(String.valueOf(S.Pop()));
		}
		return postfix;
	}
	
	// 计算后缀表达式的值，仅支持计算个位数的数字运算，如果想要计算两位数以上的，可以考虑使用控制台依次输入单个字符
	public double postfixCalculate(String postfix) {
		LinkStack S = new LinkStack();
		for (int i = 0; i < postfix.length() && postfix != null; i++) {
			char c = postfix.charAt(i);	// 从后缀表达式中依次读取字符
			if (isOperator(c)) {
				double d2 = Double.valueOf(S.Pop().toString());
				double d1 = Double.valueOf(S.Pop().toString());
				double result = 0;
				if (c == '+') {
					result = d1 + d2;
				} else if (c == '-') {
					result = d1 - d2;
				} else if (c == '*') {
					result = d1 * d2;
				} else if (c == '/') {
					result = d1 / d2;
				} else if (c == '^') {
					result = Math.pow(d1, d2);
				} else if (c == '%') {
					result = d1 % d2;
				}
				S.Push(result);
			} else {
				S.Push(c);
			}
		}
		return (double) S.Pop();
	}
	
	private boolean isLeftParenthesis(char c) {
		return '(' == c;
	}
	
	private boolean isRightParenthesis(char c) {
		return ')' == c;
	}
	
	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '^' == c) {
			return true;
		} else {
			return false;
		}
	}
	
	private int priority(char c) {
		if (c == '^') {
			return 3;
		}
		if ('*' == c || '/' == c || '%' == c) {
			return 2;
		} else if ('+' == c || '-' == c) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		ReversePolish RS = new ReversePolish();
		
		String postfix = RS.convertToPostfix("9+(3-1)*3+10/2");
		System.out.print("将算术表达式转化为后缀表达式为: " + postfix);
		System.out.println("*******************************");
		
		String postfix1 = RS.convertToPostfix("(1 + 2) * ( 5 - 2 ) / 2 ^ 2 + 5 % 3 ");
		System.out.print("将算术表达式转化为后缀表达式为: " + postfix1);
		System.out.println();
		System.out.print("计算转换后的后缀表达式的结果为: " + RS.postfixCalculate(postfix1));

	}
}
