package guice.sank.rest.app.annotation;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@BindingAnnotation
public @interface CmsApi {
}
