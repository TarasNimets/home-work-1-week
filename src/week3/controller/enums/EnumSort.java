package week3.controller.enums;

public enum EnumSort {
	
	SORT_BY_FIRST_NAME,
	SORT_BY_LAST_NAME,
	SORT_BY_AGE,
	SORT_BY_AVERAGE_MAKR,
	DEFAULT;
	
	public static EnumSort getSort(int number){
        EnumSort[] values = EnumSort.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].ordinal() == number - 1){
                return values[i];
            }
        }
        return DEFAULT;
    }


}
