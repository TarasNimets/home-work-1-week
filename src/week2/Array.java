package week2;

public class Array {
	
    private static int[] nums = new int[10];
    private static int size = 0;

    public static void main(String[] args) {

        add(10);
        add(5);
        add(7);
        add(2);
        add(15);
        add(5);
        add(0);
        add(2);
        add(10);
        add(5);
//        add(2);
//        add(2);
//        add(13);
//        add(1);
//        add(7);
//        add(9);
        

        System.out.println(get(4));

//        sort();

        System.out.println(search(2));

        add(0, 99); 
        
//        System.out.println(replace(7, 10));

//        System.out.println(remove(0));

        System.out.println(removeValue(99));

//        invert();

//        System.out.println(Arrays.toString(subArray(3, 8)));

//        System.out.println(getString());
        
        for (int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i] + " ");
        }
        System.out.println(" ");
        System.out.println("size = " + size);
        System.out.println("nums.length = " + nums.length);
        

    }

    /**
     * Add int value to the end of array.
     * if array outs index of bounds copy all values
     * to new bigger array.
     *
     * @param value - new value for nums field.
     */
    private static void add(int value) {
        if(nums.length <= size){
            copyArray();
        }
        nums[size++] = value;
    }

    private static void copyArray() {
        int[] newArray = new int[nums.length * 2];
        System.arraycopy(nums, 0, newArray, 0, nums.length);
        nums = newArray;
    }

    /**
     * @return value from this index.
     * @param index in nums.
     * @throws ArrayIndexOutOfBoundsException if no such
     *         index in nums.
     */
    private static int get(int index) {
    	return nums[index];
    }

    /**
     * Ascending sorts nums
     */
    private static void sort() {
        for (int i = 0; i < nums.length; i++) {
        	for (int k = nums.length - 1; k > i; k--) {
        		if (nums[k] < nums[k-1]) {
        			int temp = nums[k];
        			nums[k] = nums[k-1];
        			nums[k-1] = temp;
        		}
        	}
        }
    }

    /**
     * @return first founded index
     *      which associated with this value,
     *      or -1 if was not found such value.
     * @param value - searched value in nums
     */
    private static int search(int value) {
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == value) {
    			return i;
    		}
    	}
        return -1;
    }
    
    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param value element to be inserted
     * @throws IndexOutOfBoundsException if no such
     *          index in nums.
     */
    
    private static int add(int index, int value) {
    	int oldValue = nums[index];
    	int[] newArray = new int[nums.length + 1];
    		System.arraycopy(nums, 0, newArray, 0, index);
    		System.arraycopy(nums, index, newArray, index + 1, nums.length - index);
		newArray[index] = value;
		size++;
		nums = newArray;
    	return oldValue;
    }
    
    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param value element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if no such
     *          index in nums.
     */
    private static int replace(int index, int value) {
    	int oldValue = nums[index];
    	nums[index] = value;
    	return oldValue;
    }

    /**
     * @return removed value.
     * @param index removed value.
     * @throws ArrayIndexOutOfBoundsException if no such
     *          index in nums.
     */
    private static int remove(int index) {
        int oldValue = nums[index];
        int[] newArray = new int[nums.length];
        System.arraycopy(nums, 0, newArray, 0, index);
        System.arraycopy(nums, index + 1, newArray, index, nums.length - (index + 1));
        size--;
        nums = newArray;
        return oldValue;
    }
    
    private static void removeAdd (int index) {
        int[] newArray = new int[nums.length];
            System.arraycopy(nums, 0, newArray, 0, index);
            System.arraycopy(nums, index + 1, newArray, index, nums.length - (index + 1));
            size--;
        nums = newArray;
    }

    /**
     * @return removed value or -1 if was not found
     * @param value removed value.
     */
    private static int removeValue(int value) {
        int count = 0;
    	for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == value) {
        		removeAdd(i);
                count++;
                i--;
        	}
        }
        if (count > 0) {
            return value;
        }
        return -1;
    }

    /**
     * Inverts nums
     */
    private static void invert() {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	newArray[i] = nums[(nums.length - 1) - i];
        }
        nums = newArray;
    }

    /**
     * Makes copy of nums from first index to last index which
     * was received from params.
     *
     * @param from first index of subArray
     * @param to last index of subArray
     * @return subArray of the nums
     * @throws ArrayIndexOutOfBoundsException if no such
     *         indexes in nums.
     */
    private static int[] subArray(int from, int to) {
        int lenght = to - from + 1;
        int[] newArray = new int[lenght];
        System.arraycopy(nums, from, newArray, 0, lenght);
        return newArray;
    }

    /**
     * Convert nums into string.
     * @return nums in string format.
     */
    private static String getString(){
        String array = "";
        for (int i = 0; i < nums.length; i++) {
        	array += nums[i] + ", ";
        }
        
        return array;
    }


}
