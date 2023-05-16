package com.example.nabilski.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceAspects {
    @Around("execution(public * com.example.nabilski.Services.*.add*(..))") //naaref li ay add bech trajaa objet wel pjp tnajamch tekhdem b void khater les classes taa service mahomch void lkol
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object o=pjp.proceed();
        stopWatch.stop();
        log.info("execution time of {} is {}", pjp.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return o;
        //l méthode tehsebli l temps d'execution taa ay méthode nekhdmohaa
    }
}
