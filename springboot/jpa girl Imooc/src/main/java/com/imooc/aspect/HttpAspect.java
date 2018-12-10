package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 廖师兄
 * 2017-01-15 12:31
 */

@Aspect  //定义切面
@Component
public class HttpAspect {

    //使用spring自带日志框架logger打印  参数为本类的名字
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // @Pointcut 为切点，表达式重用，是指那些方法需要被执行"AOP"
    // 后面括号里的表达式定义拦截对象，*(..)表示拦截所有，girlList(..)表示只拦截girlList这个方法，(..)表示拦截任何参数
    //  定义一个公用的方法"log()"作为参数， 这个log()可以被重用 而且方便修改
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log() {
    }

    //在http请求到这些方法之前就执行doBefore()方法，"log()" 为上面定义的切点里的公用参数，只用于传入拦截对象
    //传入JoinPoint对象 AspectJ中的切入点匹配的执行点称作连接的（Join Point） 通过JoinPoint可以访问连接点的细节
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //使用RequestContextHolder 对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url   打印请求路径
        logger.info("url={}", request.getRequestURL());

        //method  请求方式
        logger.info("method={}", request.getMethod());

        //ip     客户端的ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法    请求的哪个方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数   请求的哪个参数
        logger.info("args={}", joinPoint.getArgs());
    }
    //是在所拦截方法执行之后执行doAfter() 方法r
    @After("log()")
    public void doAfter() {
        logger.info("222222222222");
    }


    //是在所拦截方法执行之后执行doAfterReturning()方法，并打印出返回值
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
