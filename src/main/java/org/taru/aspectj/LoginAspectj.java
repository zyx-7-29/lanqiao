package org.taru.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component  // 放到  容器里
@Aspect //说明这是一个 切面类
public class LoginAspectj {
    private  static final Logger logger= LoggerFactory.getLogger(LoginAspectj.class);

    @Pointcut("execution(* org.taru.service.*.*(..))")
    public void point(){}

    @Before("point()") //指定切点
    public void beforeAdvice(){
        logger.debug("我来了");
    }

    @After("point()") //指定切点
    public void afterAdvice(){
        logger.debug("我走了");
    }
}
