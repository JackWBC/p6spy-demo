package com.baicheng.springbucks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author baicheng
 * @description
 * @create 2019-03-16 17:36
 */
@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("repositoryOps()")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String name = "-";
        String result = "Y";
        try {
            name = pjp.getSignature().toShortString();
            return pjp.proceed();
        } catch (Throwable throwable){
            result = "N";
            throw throwable;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("{};{};{} ms", name, result, endTime - startTime);
        }
    }

    @Pointcut("execution(* com.baicheng.springbucks.repository..*(..))")
    private void repositoryOps(){

    }
}
