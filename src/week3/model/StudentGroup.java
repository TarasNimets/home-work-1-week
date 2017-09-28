package week3.model;

import java.util.Arrays;

public class StudentGroup {

    private  Student[] students = new Student[10];
    private  int size = 0;

    /**
     * Add int value to the end of array.
     * if array outs index of bounds copy all values
     * to new bigger array.
     *
     * @param value - new value for nums field.
     */
    public void add(Student student) {
        if(students.length <= size){
            copyArray();
        }
        students[size++] = student;
    }

    private void copyArray() {
        Student[] newArray = new Student[students.length * 2];
        System.arraycopy(students, 0, newArray, 0, students.length);
        students = newArray;
    }

    /**
     * @return value from this index.
     * @param index in nums.
     * @throws ArrayIndexOutOfBoundsException if no such
     *         index in nums.
     */
    public  Student get(int index) {
        return students[index];
    }

    /**
     * Ascending sorts nums
     */
    public  Student[] sortByFirstName() {
    	Student[] newStudent = students.clone();
        for (int i = 0; i < size; i++) {
        	for (int k = size - 1; k > i; k--) {
        		if (newStudent[k].getFirstName().compareTo(newStudent[k-1].getFirstName()) < 0) {
        			Student temp = newStudent[k];
        			newStudent[k] = newStudent[k-1];
        			newStudent[k-1] = temp;
        		}
        	}
        }
        return newStudent;
    }
    
    public  Student[] sortByLastName() {
    	Student[] newStudent = students.clone();
        for (int i = 0; i < size; i++) {
        	for (int k = size - 1; k > i; k--) {
        		if (newStudent[k].getLastName().compareTo(newStudent[k-1].getLastName()) < 0) {
        			Student temp = newStudent[k];
        			newStudent[k] = newStudent[k-1];
        			newStudent[k-1] = temp;
        		}
        	}
        }
        return newStudent;
    }  
    
    public  Student[] sortByAge() {
    	Student[] newStudent = students.clone();
        for (int i = 0; i < size; i++) {
        	for (int k = size - 1; k > i; k--) {
        		if (newStudent[k].getAge() < newStudent[k-1].getAge()) {
        			Student temp = newStudent[k];
        			newStudent[k] = newStudent[k-1];
        			newStudent[k-1] = temp;
        		}
        	}
        }
        return newStudent;
    }

    public  Student[] sortByAverageMark() {
    	Student[] newStudent = students.clone();
        for (int i = 0; i < size; i++) {
        	for (int k = size - 1; k > i; k--) {
        		if (newStudent[k].getAverageMark() < newStudent[k-1].getAverageMark()) {
        			Student temp = newStudent[k];
        			newStudent[k] = newStudent[k-1];
        			newStudent[k-1] = temp;
        		}
        	}
        }
        return newStudent;
    }

   /**
     * @return first founded index
     *      which associated with this value,
     *      or -1 if was not found such value.
     * @param firstName - searched value in nums
     */
    public  Student search(String firstNam) {
    	for (int i = 0; i < size; i++) {
    		if (students[i].getFirstName().equals(firstNam)) return students[i];
    	}
    	return null;
    }

    /**
     * @return removed value.
     * @param index removed value.
     * @throws ArrayIndexOutOfBoundsException if no such
     *          index in nums.
     */
    public  Student remove(int id) {
    	int index = searchIndexID(id);
    	if (index != -1) {
    		removeAdd(index);
    		return students[index];
    	}
        return null;
    }

    /**
     * @return removed value or -1 if was not found
     * @param firstName removed value.
     */
    public  Student removeValue(String firstName, String lastName) {
    	int index = searchIndexName(firstName, lastName);
    	if (index != -1) {
    		removeAdd(index);
    		return students[index];
    	}
        return null;
    }
    
    private int searchIndexID(int id) {
        for (int i = 0; i < size; i++) {
        	if (students[i].getID() == id) return i;
        }
        return -1;
    }
    
    public int searchIndexName(String firstName, String lastName) {
        for (int i = 0; i < size; i++) {
        	if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) return i;
        }
        return -1;
    }
    
    
    private void removeAdd (int index) {
        Student[] newArray = new Student[students.length];
            System.arraycopy(students, 0, newArray, 0, index);
            System.arraycopy(students, index + 1, newArray, index, students.length - (index + 1));
            size--;
        students = newArray;
    }

    /**
     * Convert nums into string.
     * @return nums in string format.
     */
    public  String getString(){
        String toString = "";
        for (int i = 0; i < size; i++) {
            toString +=students[i].getID() +") " +  students[i].getFirstName() + ", " + students[i].getLastName() +
                    ", " + students[i].getAge() + ", " + students[i].getAverageMark() + " \n";
        }

        return toString;
    }
    
    public  String getString(Student[] students){
        String toString = "";
        for (int i = 0; i < size; i++) {
            toString +=students[i].getID() +") " +  students[i].getFirstName() + ", " + students[i].getLastName() +
                    ", " + students[i].getAge() + ", " + students[i].getAverageMark() + " \n";
        }

        return toString;
    }

    public Student[] getStudents(){
        return students.clone();
    }

    public int size(){
        return size;
    }

	public void edit(int index, String firstName, String lastName, int age, double averageMark) {
		students[index].setFirstName(firstName);
		students[index].setLastName(lastName);
		students[index].setAge(age);
		students[index].setAverageMark(averageMark);
	}

	@Override
	public String toString() {
		return "StudentGroup [students=" + Arrays.toString(students) + ", size=" + size + "]";
	}
	

}