package LeetCode;
class LRUCache {

	int[] keyArray = null;
	int[] valueArray = null;
	int index;
	int cp;
	boolean flag;
	
    public LRUCache(int capacity) {
    	this.cp = capacity;
    	keyArray = new int[capacity];
    	valueArray = new int[capacity];
    	index = 0;
    }
    
    public int get(int key) {
        for(int i=0; i<cp; i++)
        	if(key == keyArray[i])
        		return valueArray[i];
        return -1;
    }
    
    public void put(int key, int value) {
//        if(index == keyArray.length)
    	for(int i=0; i<cp; i++) {
    		if(key == keyArray[i]) {
    			valueArray[i] = value;
    			return;
    		}
    	}
    	if(index == 0) flag = false;
    	if(index == cp-1) flag = true;
    	
    	keyArray[index] = key;
    	valueArray[index] = value;
    	
    	if(cp == 1) return;
    	
    	if(flag) index --;
    	else index ++;
    }
    
    public static void main(String[] args) {
    	LRUCache p = new LRUCache(2);
    	p.put(1, 1);
    	p.put(2, 2);
    	System.out.println(p.get(1));
    	p.put(3, 3);
    	System.out.println(p.get(2));
    	p.put(4, 4);
    	System.out.println(p.get(4));
    }
    
}
