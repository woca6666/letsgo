package com.myzone.demoutils.utils;

import com.myzone.demoutils.dto.DefaultIdGeneratorDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
public class DefaultIdGenerator implements Runnable{

    private String time;

    private AtomicInteger value;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private DefaultIdGeneratorDto config;

    private Thread thread;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void setConfig(DefaultIdGeneratorDto config) {
        this.config = config;
    }

    public DefaultIdGenerator(){
        config = new DefaultIdGeneratorDto();
        time = LocalDateTime.now().format(FORMATTER);
        value = new AtomicInteger(config.getInitial());

        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public DefaultIdGenerator(DefaultIdGeneratorDto config){
        this.config = config;
        time = LocalDateTime.now().format(FORMATTER);
        value = new AtomicInteger(config.getInitial());

        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public String next() {
        lock.readLock().lock();
        StringBuffer sb = new StringBuffer(config.getPreFix()).append(config.getSplitString()).append(time).append(config.getSplitString()).append(value.getAndIncrement());
        lock.readLock().unlock();
        return sb.toString();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000 * config.getRollingInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String now = LocalDateTime.now().format(FORMATTER);
            if (!now.equals(time)){
                lock.writeLock().lock();
                time = now;
                value.set(config.getInitial());
                lock.writeLock().unlock();
            }
        }
    }

    public static void main1(String[] args) {
//        DefaultIdGenerator defaultIdGenerator = new DefaultIdGenerator();
//        defaultIdGenerator.config.setPreFix("");
//        String next = defaultIdGenerator.next();
//        System.out.println(next);

        System.out.println("--------测试多线程性能------------------");
        ExecutorService es1 = Executors.newFixedThreadPool(500);
        DefaultIdGenerator idGenerator3 = new DefaultIdGenerator();
        long t1 = System.currentTimeMillis();
        for (int i=0; i<500; i++){
            es1.submit(() -> {
                int count = 0;
                while (count < 10000){
                    System.out.println(idGenerator3.next());

                    count++;
                }
            });
        }
        es1.shutdown();
        System.out.println("启用顺序关闭");
        while(true){
            if(es1.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            try {
                System.out.println("子线程的任务还没运行完");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("500线程,每个线程生成10000个序列号.共耗时: " + (System.currentTimeMillis() - t1) + " ms");
    }

    public static void main(String[] args) {
        DefaultIdGenerator idGenerator = new DefaultIdGenerator();

        //多线程测试
        System.out.println("--------多线程测试不重复------------------");
        Set<String> idSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i=0; i<2000000; i++){
            es.submit(() -> {
                String val = idGenerator.next();
                if (idSet.contains(val)){
                    System.out.println("重复了: " + val);
                }else{
                    idSet.add(val);
                }
            });
        }
        es.shutdown();
        System.out.println("启用顺序关闭");
        while(true){
            if(es.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            try {
                System.out.println("子线程的任务还没运行完");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("共生成: " + idSet.size() + "个");
    }

}