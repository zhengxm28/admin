package cn.xmzheng.admin.common.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Ddic {
	/**
     * (Optional) The name of the ddicCategory. Defaults to
     * the tableName_field.
     */
    String name() default "";
    /**
     * The field need map fill value.
     */
    String mapTo() default "";
}
