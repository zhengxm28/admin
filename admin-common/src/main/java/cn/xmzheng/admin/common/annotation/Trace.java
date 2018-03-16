package cn.xmzheng.admin.common.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Trace {
	/**
     * (Optional) The name of the api.method. Defaults to
     * the tableName_field.
     */
    String name() default "";
    /**
     * The api need tracing period.
     */
    String period() default "";
}
