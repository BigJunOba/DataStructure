package bigjun.iplab.sequenceList;
public class SequenceList implements IList{

	private final static int MAXSIZE = 20;
	private int[] data; //线性表存储空间
    private int length; //线性表当前长度

    //顺序表构造函数,构造一个长度为maxSize的线性表
    public SequenceList(int maxSize){
        length = 0;
        data = new int[maxSize];
    }

    //置空操作
    public void clear() {
        length = 0;
    }

    //判断当前长度是否为0,为0即为空表
    public boolean isEmpty() {
        return length == 0;
    }

    //取表长度，返回length当前长度即可
    public int getLength() {
        return length;
    }

	// 获取第i个位置的元素的值
	public int getElem(int i) throws Exception {
		if (length==0 || i < 1 || i > length) 
			throw new Exception("ERROR");
		return data[i-1];
	}

	// 在线性表的第i个位置插入新的元素
	public void insert(int i, int x) throws Exception {
		if (length == MAXSIZE) 
			throw new Exception("顺序线性表已经满");
		if (i < 1 || i > length+1) 
			throw new Exception("插入的位置已经超出的线性表的范围");
		if (i <= length)       
	    {
	        for(int k=length-1;k>=i-1;k--)  
	            data[k+1]=data[k];
	    }
	    data[i-1]=x;          
	    length++;
	}

	// 删除线性表第i个位置的元素，并且返回被删除的元素
	public void remove(int i) throws Exception {
		if (length==0) {
			throw new Exception("线性表为空");
		}
		if (i < 1 || i > length) {
			throw new Exception("删除位置不正确，无法删除");
		}
		if (i < length) {
			for (int j = i; j < length; j++) {
				data[j-1] = data[j];
			}
		}
		length--;
	}

	public void display() {
		for (int j = 0; j < length; j++) 
			System.out.print(data[j] + " ");
		System.out.println();
	}

	// 获取元素e在线性表中是什么位置
	public int locateElem(int e) {
		int j;
		if (length==0) 
			return 0;
		for (j = 0; j < length; j++) {
			if (data[j]==e) 
				break;
		}
		if (j >= length) {
			return 0;
		}
		return j+1;
	}
	
	// 合并两个集合
	public void union(IList bIList) throws Exception {
		int bLength = bIList.getLength();
		for (int i = 1; i <= bLength; i++) {
			int bElem = bIList.getElem(i);
			if (this.locateElem(bElem) == 0) {
				System.out.println(bElem);
				this.insert(1, bElem);
			}
		}
	}

    public static void main(String[] args) throws Exception {
		SequenceList sqList = new SequenceList(MAXSIZE);
		System.out.println(sqList.isEmpty());
		for (int i = 1; i <= 5; i++) 
			sqList.insert(1, i);
		System.out.println(sqList.isEmpty());
		sqList.display();
		sqList.clear();
		System.out.println(sqList.isEmpty());
		
		for (int j = 1; j <= 10; j++) 
			sqList.insert(j, j);
		sqList.display();
		
		sqList.insert(1, 0);
		sqList.display();
		
		System.out.println("第5个位置的元素是：" + sqList.getElem(5));
		
		for (int i = 3; i <= 4; i++) {
			int k = sqList.locateElem(i);
			if (k != 0) {
				System.out.println("第" + k + "个位置的元素是：" + i);
			} else {
				System.out.println("没有值为" + i + "的元素");
			}
		}
		
		sqList.display();
		int len = sqList.getLength();
		System.out.println(len);
		System.out.println(sqList.getElem(len));
		sqList.remove(len);
		sqList.display();
		
		System.out.println(sqList.getElem(5));
		sqList.remove(5);
		sqList.display();
		
		SequenceList bList = new SequenceList(MAXSIZE);
		for (int i = 6; i <= 15; i++) 
			bList.insert(1, i);
			bList.display();
		sqList.union(bList);
		sqList.display();
	}
    
}