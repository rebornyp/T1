package useful;

/**
 * 分治法和减治法分别去求解最大子数组问题
 * @author Gastby
 *
 */
public class MostSonArray {  
    public static void main(String[] args) {  
        int[] a = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };  
        int[] s = getMaxSummary(a, 0, 15);  
        for (int i = 0; i < s.length; i++) {  
            System.out.print(s[i] + "-");
            System.out.print("");
        }  
        System.out.println();
        System.out.println("Max sum: " + MostSonArray.getMax(a));  
    }  
  
    /** 
     * 程序主入口 
     * @param A 
     * @param low 
     * @param high 
     * @return 
     */  
    public static int[] getMaxSummary(int[] A, int low, int high) {  
        if (low == high) { // 如果長度就一個，那麼就把這個取出來  
            int[] result = { low, high, A[low] };  
            return result;  
        } else {  
            int middle = (int) Math.floor((low + high) / 2); // 获取中间值  
            int[] left = new int[3]; // 保存左边部分返回结果  
            int[] right = new int[3]; // 保存右边部分返回结果  
            int[] cross = new int[3]; // 返回交叉部分返回结果  
            left = getMaxSummary(A, low, middle);  
            right = getMaxSummary(A, middle + 1, high);  
            cross = getMaxCrossMid(A, low, high, middle);  
            if (left[2] >= right[2] && left[2] >= cross[2]) {   // 那部分大就用了那部分  
                return left;  
            } else if (right[2] >= left[2] && right[2] >= cross[2]) {  
                return right;  
            } else {  
                return cross;  
            }  
        }  
    }  
  
    /** 
     * 獲取最大子數組（一部分在左邊，一部分在右邊） 
     *  
     * @param A 
     * @param low 
     * @param high 
     * @param middle 
     * @return 
     */  
    public static int[] getMaxCrossMid(int[] A, int low, int high, int middle) {  
        int leftSum = Integer.MIN_VALUE;  
        int sum = 0; // 保存和的  
        int left = 0; // 记录左边位置  
        for (int i = middle; i >= low; i--) {  
            sum = sum + A[i];  
            if (sum > leftSum) { // 证明所加数字为正数，那么符合条件（因为最大子数组内正数越多指定越大）  
                leftSum = sum;  
                left = i;  
            }  
        }  
  
        int rightSum = Integer.MIN_VALUE;  
        int sum2 = 0;  
        int right = 0; // 记录右边位置  
        for (int i = middle + 1; i <= high; i++) {  
            sum2 = sum2 + A[i];  
            if (sum2 > rightSum) {  
                rightSum = sum2;  
                right = i;  
            }  
        }  
  
        int[] result = new int[3];  
        result[0] = left;  
        result[1] = right;  
        result[2] = leftSum + rightSum;  
        return result;  
    }  
  
      
    private static long getMax(long a, long b) {  
        return a > b ? a : b;  
    }  
      
    /** 分治法求得最大子数组问题
     * 获得连续子数组的最大和 
     * @param array 
     * @return 最大和，此处用了Long型是为了表示当参数为null或空时，可以返回null，返回其它任何数字都可能引起歧义。 
     */  
    public static Long getMax(int[] array) {  
          
        if (array == null || array.length <= 0) {  
            return null;  
        }  
          
        long maxSum = array[0]; //所有子数组中最大的和  
        long righteEdge = array[0]; //右侧子数组的最大和  
        for (int i = 1; i < array.length; i++) {  
            //当右侧子数组的最大和为负数时，对于新数组，右侧子数组的最大和为新增加的数。  
            if (righteEdge < 0) {  
                righteEdge = array[i];  
            } else { //为正数时，对于新数组，右侧子数组的最大和为新增加的数 + 原来的最大和。  
                righteEdge += array[i];  
            }  
            //所有子数组中最大的和  
            maxSum = getMax(righteEdge, maxSum);  
        }  
        return maxSum;  
    }   
      
}