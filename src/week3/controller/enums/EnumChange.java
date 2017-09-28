package week3.controller.enums;

public enum EnumChange {
	
    CHANGE_FIRST_NAME,
    CHANGE_LAST_NAME,
    CHANGE_AGE,
    CHANGE_AVERAGE_MAKR,
    CHANGE_ALL;

    
	
	
	public static EnumChange getChange(int number){
        EnumChange[] values = EnumChange.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].ordinal() == number - 1){
                return values[i];
            }
        }
        return CHANGE_ALL;
    }

}
