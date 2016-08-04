package cn.track.service.aop;

import java.lang.annotation.*;

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface EventCutPoint {
}
