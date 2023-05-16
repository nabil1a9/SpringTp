package com.example.nabilski.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspects {
    @Before("execution(public * com.example.nabilski.Services.*.*(..))")  //l'étoile loula li kbal tn lel type de retour wel nejma theniaa lel nom de la méthode
    public void inMethod(JoinPoint jp){
        log.info("in method"+jp.getSignature().getName());
    }
    @AfterReturning("execution(public * com.example.nabilski.Services.*.*(..))")  //l'étoile loula li kbal tn lel type de retour wel nejma theniaa lel nom de la méthode
    public void outMethodReturn(JoinPoint jp){
        log.info("out method returning"+jp.getSignature().getName());
    }
    @AfterThrowing("execution(public * com.example.nabilski.Services.*.*(..))")  //l'étoile loula li kbal tn lel type de retour wel nejma theniaa lel nom de la méthode
    public void outMethodThrow(JoinPoint jp){
        log.info("out method throwing"+jp.getSignature().getName());
    }
    @After("execution(public * com.example.nabilski.Services.*.*(..))")  //l'étoile loula li kbal tn lel type de retour wel nejma theniaa lel nom de la méthode
    public void outMethodAfter(JoinPoint jp){
        log.info("out method after"+jp.getSignature().getName());
    }
    //after returning nestaamloha fel try, mchet mrigla yaani
    //after throwing nestaamloha fel catch, sar lancement lel exception
    //after nestaamloha fel finally
}
