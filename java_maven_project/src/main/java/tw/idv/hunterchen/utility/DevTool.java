package tw.idv.hunterchen.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevTool {
	/**
	 * @param obj
	 * @return
	 */
	private static String mDivider = StringTool.genDivider();
	
	public static boolean showAllMembers(Object obj) {
		DevTool.showMessages("套件.類別全名", obj.getClass().getCanonicalName()
					, obj.hashCode()+"("+Integer.toHexString(obj.hashCode()) +")", obj.toString());
		return (	showAllFields(obj)  && showAllMethods(obj)
			   );
	}

	public static boolean showAllFields(Object obj) {
		boolean isSuccess = true;
		try {
			DevTool.showMessages(mDivider
					, "套件.類別全名 " + obj.getClass().getName() + " 之屬性"
					, mDivider);
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				DevTool.showMessages(field.getName()
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
			DevTool.showMessages(mDivider
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
			System.out.printf("<=MBH=>");
			for (int i=0; i<messages.length; i++) {
				System.out.printf(": %20s", messages[i]);
			}
			System.out.printf("%n");
		}
	}
	
	/*	XXX: 不同型別的不定數參數
	public static void showMessages(Object...objects ) {
		
	}
	*/
	
	public static String getOsName() {
		String result=null;
		String osName = System.getProperty("os.name");
		DevTool.showMessages(osName);
		switch (osName) {
			case "Mac OS X":
				result = "MacOS"; break;
			case "Windows":
				result = "Windows"; break;
			case "linux":
				result = "Linux"; break;
			default:
				result = "Unknown"; break;
		}
		return result;
	}

//	 public static void showAllElements(Collection elements) {
//		elements.forEach(element -> {showMessages(element.toString());});
//	}
	public static void main(String[] arg) {
		showMessages(getOsName());
	}
}
