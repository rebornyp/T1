package useful;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class QueueTest {

	static char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		int[] arr = {3, 5, 7, 9, 10};
		PrintStream pw = System.out;
		char[] ch = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
		char[][] board = new char[9][9];
		Random r = new Random();
		for(int i=1; i<10; i++)
			pw.println(countAndSay(i));
	}
	
	public static String countAndSay(int n) {
		if(n < 1)
			return null;
		if(n == 1)
			return "1";
		else if(n == 2)
			return "11";
		else {
			String str = countAndSay(n-1);
			StringBuilder temp = new StringBuilder();
			int num = 1;
			for(int i=1; i<str.length(); i++) {
				if(str.charAt(i) == str.charAt(i-1))
					num ++;
				else {
					temp.append(String.valueOf(num) + str.charAt(i-1));
					num = 1;
				}
				if(i == str.length() - 1)
					temp.append(String.valueOf(num) + str.charAt(i));
			}
			return temp.toString();
		}
    }
	
	private static void show(char[][] board) {
		// TODO Auto-generated method stub
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9)
			return false;
		boolean flag = true;
		Set<Character> tempDict = new HashSet<Character>();
		Set<Character> dict = new HashSet<Character>();
		for(int i=0; i<10; i++) {
			dict.add(c[i]);
		}
		for(int i=0; i<9; i++) {
			tempDict.clear();
			for(int j=0; j<9; j++) {
				if(dict.add(board[i][j]) == true || (board[i][j] != '.' && tempDict.add(board[i][j]) == false)) {
					flag = false;
					break;
				}
			}
			if(flag == false)
				break;
		}
		if(flag == false)
			return false;
		for(int i=0; i<9; i++) {
			tempDict.clear();
			for(int j=0; j<9; j++) {
				if(dict.add(board[j][i]) == true || (board[j][i] != '.' && tempDict.add(board[j][i]) == false)) {
					flag = false;
					break;
				}
			}
			if(flag == false)
				break;
		}
//		System.out.println(flag);
		if(flag == false)
			return false;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				tempDict.clear();
				for(int u=0; u<3; u++) {
					for(int v=0; v<3; v++) {
//						System.out.println(i * 3 + u + "-" + (j * 3 + v));
						int m = i * 3 + u, n = j * 3 + v;
						if(dict.add(board[m][n]) == true || (board[m][n] != '.' && tempDict.add(board[m][n]) == false)) {
							flag = false;
							break;
						}
					}
					if(flag == false)
						break;
				}
				if(flag == false)
					break;
			}
			if(flag == false)
				break;
		}	
		if(flag == false)
			return false;
		return true;
    }
	
	public static int searchInsert(int[] arr, int target) {
		if(arr == null || arr.length == 0)
			return 0;
		if(arr[0] > target)
			return 0;
		if(arr[arr.length - 1] < target)
			return arr.length;
		return binarySearch(arr, 0, arr.length - 1, target);
    }
	
	private static int binarySearch(int[] arr, int left, int right, int target) {
		if(left >= right) {
			if(arr[left] == target)
				return left;
			else if(arr[left] < target)
				return left + 1;
			else
				return left;
		}
		int mid = (left + right) / 2;
		if(arr[mid] == target)
			return mid;
		else if(arr[mid] < target)
			return binarySearch(arr, mid+1, right, target);
		else
			return binarySearch(arr, left, mid-1, target);
	}

	public static int[] searchRange(int[] A, int target) {
	    int[] res = {-1,-1};  
	    if(A==null || A.length==0)  
	    {  
	        return res;  
	    }  
	    int ll = 0;  
	    int lr = A.length-1;  
	    while(ll<=lr)  
	    {  
	        int m = (ll+lr)/2;  
	        if(A[m]<target)  
	        {  
	            ll = m+1;  
	        }  
	        else  
	        {  
	            lr = m-1;  
	        }  
	    }  
	    int rl = 0;  
	    int rr = A.length-1;  
	    while(rl<=rr)  
	    {  
	        int m = (rl+rr)/2;  
	        if(A[m]<=target)  
	        {  
	            rl = m+1;  
	        }  
	        else  
	        {  
	            rr = m-1;  
	        }  
	    }  
	    if(ll<=rr)  
	    {  
	        res[0] = ll;  
	        res[1] = rr;  
	    }  
	    return res;
    }
	
	

/**
 * 思路一并没有充分利用条件，及这个数组是由两个有序的子数组合成的。这里我们可以使用二分法的一个变形的算法。
 * 先找到中间节点，这个中间节点如果不是在左顺序子数组，就一定在右顺序子数组，反之亦成立。
 * 这样我们就可以变相的使用二分法将区间范围逐渐缩小，直至找到目标值。
 * 这里相比于思路一，更适用于目标节点在中间的情况，而思路一在目标节点分布在数组两侧会效率更高。
 * @param nums  
 * @param target
 * @return
 */
	private static int search(int[] nums, int target) {
		// TODO Auto-generated method stub
		int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = (left + right)/2;
            PrintStream pw = System.out;
            pw.println((left + "-" + right + "-" + mid));
            int midNum = nums[mid];
            if(midNum==target){
                return mid;
            }
            if(nums[left]<=midNum){
                if(nums[left]<=target && midNum>target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else {
                if (target > midNum && target <= nums[right])
                    left = mid + 1;
                 else
                    right = mid - 1;
            }
        }
        return -1;
	}

	static public void nextPermutation(int[] arr) {
		if(arr == null || arr.length <= 0)
			return;
		int flip = arr.length - 1;
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i] > arr[i-1]) {
				flip = i - 1;
				break;
			}
		}
		int br = arr.length - 1;
		for(int i=arr.length-1; i>flip; i--) {
			if(arr[i] - arr[flip] > 0) {
				br = i;
				break;
			}
		}
		if(flip != br) {
			int temp = arr[flip];
			arr[flip] = arr[br];
			arr[br] = temp;
		}
		int i = (flip + 1) % arr.length, j = arr.length - 1;
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i ++;
			j --;
		}
    }

}
