package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CakeTuneProblem {  
    
    public static int min;//记录所需要翻转的最少次数  
    public static int estimateMin;//记录所需要翻转的最少次数  
    public static int minNum;//记录所需要翻转的最少次数  
    public static int[] cakeArray;//抽象化的大小不一的饼的数组序列，左边第0个位置是顶部，最右边是底部饼，保存的是饼的大小数值  
    public static int[] resultArray;//毫无用处的数组引用，只是在最后方便你查看这颗搜索树的状态，随时把它替换为更优的tempArray  
    public static int[] tempArray;//这是一个记录翻转操作过程中每次是从第几个饼翻转的，记录的是所有翻转操作的翻转数组的下标值
    public static int count = 0;   //记录总共搜索了多少次，search函数执行的次数，也是这颗整体搜索树的规模大小
    public static List<Integer> templist, finalList; //优化后直接用list来保存，不用受固定长度的约束
      
    /**
     * 这里的最理想情况是如果两个饼大小只要相差1不管顺序或是逆序都认为他们不需要再翻转了
     * 而挤挨的两个饼如果相差大于1那么就肯定需要一次翻转，
     * 总装实际需要翻转次数只多不少
     * @param 
     * @return
     */
    public static int lowBound(){  
        int reduce;  
        int m = 0;  
        for(int i = 0; i < cakeArray.length-1; i++){  
            reduce = cakeArray[i] - cakeArray[i+1];  
            if(reduce == 1 || reduce == -1){  
            }  
            else{  
                m ++;  
            }  
        }  
        return m;  
    }   

    
    /**
     * 将cakeArray里的数组从顶部第0个到第index个饼全部翻转
     * @param index
     */
    public static void reverse(int index){  
        int i = 0;  
        int j = index;  
        int temp;  
        while(i < j){  
            temp = cakeArray[i];  
            cakeArray[i] = cakeArray[j];  
            cakeArray[j] = temp;  
            i++;  
            j--;  
        }  
    }  
      
    /**
     * 判断一摞饼是否已经有序  
     * @param 
     * @return
     */
    public static boolean isSorted(){  
        for(int i = 1; i < cakeArray.length; i++){  
            if(cakeArray[i-1] > cakeArray[i]){  
                return false;  
            }  
        }  
        return true;  
    }  
      
    /**
     * 应该是所有搜索的主函数，函数将递归调用自己
     * @param depth 现在已经翻转了多少次了
     */
    public static void search(int depth){  
        count++;  //这是用来记录搜索次数的变量
        estimateMin = lowBound();  //用来估算最理想情况下这摞饼需要翻转的最小次数， 
        
        //减支函数，depth因为递归不断在叠加，所以每次动态估算的需要翻转最佳次数也会变化，
        //如果此刻的depth加上此刻改变后的饼数组估算的翻转最小次数已经大于min了，就没有继续递归的必要了
        if((depth + estimateMin) >= min) return;  
        
        //如果饼数组已经有序了
        if(isSorted()){  
        	//min是全局最小翻转数，只要找到一个比它小的次数，就动态更新为此时的depth
            if(min > depth){  
                min = depth;  
                finalList = new ArrayList<Integer>(templist);
//                resultArray = Arrays.copyOf(tempArray, tempArray.length);  
//                System.out.println("当前最少翻转次数cur_min = " + min);  
            }  
            return;  
        }  
        
        //这就是类似于枚举做法的从顶到底实验这一次翻转是翻到第i号饼
        for(int i = 1; i < cakeArray.length; i++){  
            if(depth != 0 && tempArray[depth] == i){  
                continue;  
            }  
            reverse(i);  
            templist.add(i);
//            tempArray[depth+1] = i;  
            search(depth+1);  
            reverse(i); 
            templist.remove(templist.size()-1);
        }  
    } 
    
    /**
     * 很多人看编程之美里包括我也是，这main函数初看，这些操作好晦涩难懂啊，请先将下面涉及的静态变量的说明看下，
     * 主函数主要是先初始化静态饼信息数组cakeArray，以及中间搜索树数组tempArray，
     * 编程之美书中还初始化了resultArray在我看来是毫无必要的，毕竟resultArray完全没参与到算法中，只记录下结果而言，所以我把这部分删了
     * tempArray长度比min大1，是因为在search方法里tempArray[]数组记录的是操作的下标值，然而i却每次都跳过第0个也就是顶部元素，
     * 因为翻转单个饼毫无意义，所以tempArray[0]默认一直是0；
     * 然后由search(0)直接进入搜索树中，这里的depth=0，是指你的第0步操作，代表翻转了0次
     * @param args
     */
    public static void main(String[] args) {  
//    	cakeArray = createRandomArr(10); //生成10个乱序排列的饼数组
    	cakeArray = new int[] {4, 2, 1, 3}; //初始化一摞饼，4在顶部，3在底部
    	min = 2 * cakeArray.length - 2;  //已知的最优操作数就是左边大小
        tempArray = new int[cakeArray.length * 2 - 1];  //搜索树中间计算数组，比min小1是非常有必要的，如果相等会报错
        templist = new ArrayList<Integer>();
        search(0);  
        
        System.out.println(Arrays.toString(resultArray));
        System.out.println(Arrays.toString(tempArray));
        System.out.println(templist);
        System.out.println(finalList);
        System.out.println("\n最终最少翻转次数final_min = " + min);  
        System.out.println("\nTotal Run Times: " + count);  
    }  
    
    /**
     * 产生n个饼的任意顺序排列的函数，饼大小在1~n之间
     * @param n 输入饼数量
     * @return 返回饼数组对象引用
     */
    static int[] createRandomArr(int n) {
    	int[] arr = new int[n];
    	List<Integer> list = new ArrayList<Integer>();
		int k = 1;
		while(k <= n)
			list.add(k ++);
		Collections.shuffle(list);
		arr = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			arr[i] = list.get(i);
		return arr;
    }
  
}  