package com.inspur.cn.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.inspur.cn.controller..*(..))")
    public void log(){
    }

    @After("log()")
    public void doAfter(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url->{}",request.getRequestURL());
        //方法名
        logger.info("method->{}",request.getMethod());
        //ip
        logger.info("ip->{}",request.getRemoteAddr());
        //类方法
        logger.info("class_method->{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args->{}",joinPoint.getArgs());

    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doReturning(Object object){
        logger.info("response->{}",object.toString());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object ob = null;
        long startTime = 0;
        try {
            startTime = System.currentTimeMillis();
            ob = pjp.proceed();// ob 为方法的返回值
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("耗时(ms): {}" ,System.currentTimeMillis() - startTime);
        }
        logger.debug("返回值类型 : {}" ,ob);
        return ob;
    }

}
