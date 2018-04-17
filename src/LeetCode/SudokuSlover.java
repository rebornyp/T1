package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SudokuSlover {

	public static void main(String[] args) {
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//		System.out.println(spiralOrder(matrix));

		int[] arr = {1, 2, 3, 4};
		ProcessArray pa = new ProcessArray();
		pa.process(arr, new In() {

			@Override
			public void cmd(int[] arr) {
				int sum = 0;
				for(int i=0; i<arr.length; i++)
					sum += arr[i];
				System.out.println("最后结果: " + sum);
			}
			
		});
		pa.process2(() -> System.out.println("不带参数列表的lambda表达式"));
		pa.process3((wea) -> System.out.println("带一个参数列表的lambda表达式" + wea));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length - 1, n = matrix[0].length - 1;
        List<Integer> list = new ArrayList<Integer>();

        return list;
    }

}

interface In {
	void cmd(int[] arr);
}

interface In2 {
	void pay();
}

interface In3 {
	void pay(String str);
}

class ProcessArray {
	void process(int[] arr, In i) {
		i.cmd(arr);
	}
	
	void process2(In2 i) {
		i.pay();
	}
	
	void process3(In3 i) {
		i.pay("odoefho");
	}
}