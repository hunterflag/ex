package tw.idv.hunterchen.utility;

import java.lang.reflect.Field;

public class ShowTool {
	/**
	 * 
	 * @param obj
	 * @return
	 * 
	 */
	public static boolean showAllFields(Object obj) {
		boolean isSuccess = true;
		try {
			System.out.printf("==== class: %s ====\n"
					, obj.getClass()
					, obj.toString()
					);
			
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				System.out.printf("%s : %s\n"
						, field.getName()
						, String.valueOf(field.get(obj))
						);
				
			}
		}catch(Exception ex) {
			isSuccess=false;
			ex.printStackTrace();
		}finally{
			return isSuccess;			
		}
	}
}
