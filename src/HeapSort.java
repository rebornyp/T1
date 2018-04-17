import java.util.ArrayList;

public class HeapSort {  
        public static void main(String[] args) {  
            int[] array = {0, -1};  
            System.out.println("Before heap:");  
            printArray(array);  
            heapSort(array);  
            System.out.println("After heap sort:");  
            printArray(array);
            System.out.println("After heap sort:");
            reverse(array);
            printArray(array);
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.add(1);
        }  
  
        /**
         * 逆转一个数组的算法
         * @param array
         */
        private static void reverse(int[] array) {
			// TODO Auto-generated method stub
        	int left = 0, right = array.length - 1;
        	int temp;
        	while(left < right) {
        		temp = array[left];
        		array[left] = array[right];
        		array[right] = temp;
        		left ++;
        		right --;
        	}
		}

		public static void printArray(int[] array) {  
            System.out.print("{");  
            for (int i = 0; i < array.length; i++) {  
                System.out.print(array[i]);  
                if (i < array.length - 1) {  
                    System.out.print(", ");  
                }  
            }  
            System.out.println("}");  
        }
        
        public static void exchangeElements(int[] array, int index1, int index2) {  
            int temp = array[index1];  
            array[index1] = array[index2];  
            array[index2] = temp;  
        } 
        /**
         * 堆排序主算法部分
         * @param array
         */
        public static void heapSort(int[] array) {  
            if (array == null || array.length <= 1)
                return;  
            buildMaxHeap(array);  //建堆的算法
            for (int i = array.length - 1; i >= 1; i--) {  
                exchangeElements(array, 0, i);  
                maxHeap(array, i, 0);  
            }  
        }  
  
        /**
         * 建堆算法
         * @param array
         */
        private static void buildMaxHeap(int[] array) {    
            int half = array.length / 2;  
            for (int i = half; i >= 0; i--)   
                maxHeap(array, array.length, i); 
            
        }  
  
        /**
         * 沉降法
         * @param array
         * @param heapSize
         * @param index
         */
        private static void maxHeap(int[] array, int heapSize, int index) {  
            int left = index * 2 + 1;  
            int right = index * 2 + 2;  
  
            int largest = index;  
            if (left < heapSize && array[left] > array[index]) {  
                largest = left;  
            }  
  
            if (right < heapSize && array[right] > array[largest]) {  
                largest = right;  
            }  
  
            if (index != largest) {  
                exchangeElements(array, index, largest);  
                maxHeap(array, heapSize, largest);  
            }  
        }  
    }  