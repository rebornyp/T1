package useful;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortPractice {
	public static void main(String[] args) throws IOException {
		String digits = "25525511135";
		
		int[] arr = {-11, 3, -1, 20, 5, -34, 0, 12, -65};
		System.out.println(mostSubArray(arr));
		
	}

	private static List<Integer> mostSubArray(int[] arr) {
		int[] sum = new int[arr.length];
		List<Integer> list = new ArrayList<Integer>();
		sum[0] = arr[0];
		int maxSum = sum[0], start = 0, end = 0, temp = 0;
		for(int i=1; i<arr.length ;i++) {
//			sum[i] = arr[i] > sum[i-1] + arr[i] ? arr[i] : sum[i-1] + arr[i]; 
			if(arr[i] > arr[i] + sum[i-1]) {
				sum[i] = arr[i];
				temp = i;
			} else
				sum[i] = sum[i-1] + arr[i];
			
			if(sum[i] > maxSum) {
				maxSum = sum[i];
				start = temp;
				end = i;
			}
		}
		for(int i=start; i<=end; i++)
			list.add(arr[i]);
		return list;
	}

	private static void MergeSort(int[] arr, int p, int q) {
    	if(p == q)
    		return;
    	int mid = (p + q) / 2;
    	MergeSort(arr, p, mid);
    	MergeSort(arr, mid + 1, q);
    	int[] temp = new int[q-p+1];
    	int i = p, j = mid + 1, index = 0;
    	while(i <= mid && j <= q) {
    		if(arr[i] < arr[j])
    			temp[index] = arr[i ++];
    		else
    			temp[index] = arr[j ++];
    		index ++;
    	}
    	
    	while(i <= mid)
    		temp[index ++] = arr[i ++];
    	while(j <= q)
    		temp[index ++] = arr[j ++];
    	index = 0;
    	for(i=p; i<=q; i++)
    		arr[i] = temp[index ++];
	}

	public List<String> restoreIpAddresses(String s) {
        
    	return null;
    }
	
	private static void show(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "-");
			temp = temp.next;
		}
	}

	private static ListNode reverse(ListNode head) {
		ListNode p, q, r;
		p = head;
		q = null;
		
		while(p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		return q;
	}
	
}
