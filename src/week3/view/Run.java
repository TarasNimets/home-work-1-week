package week3.view;

import week3.controller.School;
import week3.controller.enums.Menu;

public class Run {
    public static void main(String[] args) {
        
        School school = new School();
        school.getScanner().write("Hello this is School program");

        while (true) {

            school.getSchoolManager().showMenu();

            Menu menu = Menu.getMenu(school.getScanner().readInt("Choose your act"));
            switch (menu) {
                case ADD_STUDENT: {
                    school.getSchoolManager().addStudent();
                    break;
                }
                case REMOVE_STUDENT: {
                    school.getSchoolManager().removeStudent();
                    break;
                }
                case SEARCH_STUDENT: {
                    school.getSchoolManager().searchStudent();
                    break;
                }
                case EDIT_STUDENT: {
                    school.getSchoolManager().editStudent();
                    break;
                }
                case SORT_STUDENTS: {
                    school.getSchoolManager().sortStudents();
                    break;
                }
                case SHOW_STUDENTS: {
                    school.getSchoolManager().showAllStudents();
                    break;
                }
                case EXIT: {
                    school.getScanner().write("Bye");
                    return;
                }
                case DEFAULT : {
                	System.out.println("Incorrect choose. Try again");
                }
            }

        }
    }
}