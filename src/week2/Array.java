package week2;

import java.util.Arrays;

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
        add(2);
//        add(2);
//        add(13);
//        add(1);
//        add(7);
//        add(9);
        

        System.out.println(get(4));

        sort();

        System.out.println(search(2));

//        add(1, 10);        

//        System.out.println(remove(7));

//        System.out.println(removeValue(7));

//        invert();

//        System.out.println(Arrays.toString(subArray(3, 8)));

        System.out.println(getString());
        
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
        if (index >= nums.length) return -1;
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
     * Add new value or replace old value
     * @return return old value or -1.
     * @param index of nums
     * @param value for insert.
     *
     * @throws ArrayIndexOutOfBoundsException if no such
     *         index in nums.
     */
    private static int add(int index, int value) {
//        if (index < nums.length) {
//        	int oldValue = nums[index];
//        	nums[index] = value;
//        	return oldValue;
//        }else {
//        	while (index > nums.length) {
//        		copyArray();
//        	}
//        	nums[index] = value;
//        }
//        return -1;
//    	or
//    	if (index < nums.length) {
//    		int oldValue = nums[index];
//    		nums[index] = value;
//    		return oldValue;
//    	}else {
//    		add(value);
//    	}
//    	return -1;
//        or
        if (index >= nums.length) return -1;
        if (index <= size) {
        	int oldValue = nums[index];
        	nums[index] = value;
        	return oldValue;
        }else {
        	nums[index] = value;
        	return -1;
        }
    }

    /**
     * @return removed value.
     * @param index removed value.
     * @throws ArrayIndexOutOfBoundsException if no such
     *          index in nums.
     */
    private static int remove(int index) {
        if (index >= nums.length) return -1;
        int oldValue = nums[index];
        int[] newArray = new int[nums.length];
        if (index == 0) {
        	System.arraycopy(nums, 1, newArray, 0, nums.length - 1);
        	size--;
        }else {
            System.arraycopy(nums, 0, newArray, 0, index);
            System.arraycopy(nums, index + 1, newArray, index, nums.length - (index + 1));
            size--;
        }
        nums = newArray;
        return oldValue;
    }

    /**
     * @return removed value or -1 if was not found
     * @param value removed value.
     */
    private static int removeValue(int value) {
        int count = 0;
    	for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == value) {
                int[] newArray = new int[nums.length];
                if (i == 0) {
                	System.arraycopy(nums, 1, newArray, 0, nums.length - 1);
                	size--;
                }else {
                    System.arraycopy(nums, 0, newArray, 0, i);
                    System.arraycopy(nums, i + 1, newArray, i, nums.length - (i + 1));
                    size--;
                }
                nums = newArray;
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
        if (from >= nums.length || to >= nums.length || from > to) {
        	return null;
        }
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
