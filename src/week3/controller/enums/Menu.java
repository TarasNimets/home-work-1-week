package week3.controller.enums;

public enum Menu {

    ADD_STUDENT,
    REMOVE_STUDENT,
    SEARCH_STUDENT,
    EDIT_STUDENT,
    SORT_STUDENTS,
    SHOW_STUDENTS,
    EXIT,
    DEFAULT;


    public static Menu getMenu(int number){
        Menu[] values = Menu.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].ordinal() == number - 1){
                return values[i];
            }
        }
        return DEFAULT;
    }

}