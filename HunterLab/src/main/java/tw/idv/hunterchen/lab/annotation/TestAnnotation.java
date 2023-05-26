package tw.idv.hunterchen.lab.annotation;

public @interface TestAnnotation {
	String value() default "";
	String singleValue() default "default value for value";
//	String singleValue1() default {"default value for value", "default value for value", "default value3 for value"};
	String[] multiValues() default {"default value for value", "default value for value", "default value3 for value"};
//	String multiValues1[]() default {"default value for value", "default value for value", "default value3 for value"};
//	String multiValues2()[] default {"default value for value", "default value for value", "default value3 for value"};
}
