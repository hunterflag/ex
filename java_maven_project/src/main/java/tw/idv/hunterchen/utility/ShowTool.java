package tw.idv.hunterchen.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Properties;

public class ShowTool {
	/**
	 * 
	 * @param obj
	 * @return
	 * 
	 */
	private static String mDivider = StringTool.genDivider("<=MBH=>");
	
	public static boolean showAllMembers(Object obj) {
		return ( showAllFields(obj)
				&& showAllMethods(obj)
				);
	}

	public static boolean showAllFields(Object obj) {
		boolean isSuccess = true;
		try {
			ShowTool.showMessages(mDivider
					, obj.getClass().getName()
					, obj.toString()
					, mDivider);
			ShowTool.showMessages(mDivider, "fields", mDivider );
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				ShowTool.showMessages(field.getName()
						, String.valueOf(field.get(obj))
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
	
	public static boolean showAllMethods(Object obj) {
		boolean isSuccess = true;
		try {
			ShowTool.showMessages(mDivider
					, obj.getClass().getName()
					, obj.toString()
					, mDivider);
			
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
	
	public static void showSystem() {
		Properties properties = System.getProperties();
		String userDir = properties.getProperty("user.dir");
		System.out.println(userDir);
	}
	
	//TODO: 自動取得引數名稱
	public static void showMessages(String... messages) {
		if ((messages!=null) && (messages.length>0)) {
			System.out.printf("===>");
			for (int i=0; i<messages.length; i++) {
				System.out.printf(": %s", messages[i]);
			}
			System.out.printf("%n");
		}
	}
	
	/*	XXX: 不同型別的不定數參數
	public static void showMessages(Object...objects ) {
		
	}
	*/
}
