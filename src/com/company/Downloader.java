package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Downloader extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int id;

    public Downloader(Semaphore semaphore, CountDownLatch countDownLatch, int id) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("user " + id + " start downloading");

        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("user " + id + " finished downloading");
        System.out.println("____________________________");
        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }

        semaphore.release();
        countDownLatch.countDown();
        super.run();
    }
}
