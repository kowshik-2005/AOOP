import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RangeAnnotation {
    double min() default 0;
    double max() default Double.MAX_VALUE;
}
