package tw.idv.hunterchen.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

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
			System.out.printf("==== class: %s ==== start ....\n"
					, obj.getClass()
					, obj.toString()
					);
			
			System.out.printf("-------- fields -----------\n");
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				System.out.printf("%s : %s\n"
						, field.getName()
						, String.valueOf(field.get(obj))
						);
				
			}

			System.out.printf("-------- methods -----------\n");
			Method[] methods = obj.getClass().getDeclaredMethods();
			for(Method method : methods) {
				method.setAccessible(true);
				System.out.printf("%s %s(%s)\n"
						, method.getReturnType().getSimpleName()
						, method.getName()
						, getParamStringOfMethod(method)
						);
				
			}

			System.out.printf("==== class: %s ==== end ....\n"
					, obj.getClass()
					, obj.toString()
					);
		}catch(Exception ex) {
			isSuccess=false;
			ex.printStackTrace();
		}finally{
			return isSuccess;			
		}
	}

	private static String getParamStringOfMethod(Method method) {
		String result="";
		Parameter[] parameters = method.getParameters();
		if(parameters.length != 0) {
			for(Parameter parameter : parameters) {
				if ("".contentEquals(result)) {
					result += parameter.getType().getSimpleName() ;
				}else {
					result += ", " + parameter.getType().getSimpleName() ;
				}
			}
		}
		return result;
	}
}
