package com.company;

import java.util.concurrent.CountDownLatch;


public class Uploader extends Thread {

    CountDownLatch cdl;

    public Uploader(CountDownLatch cdl) {
        int size = 500;
        int speed = 20;
        this.cdl = cdl;

    }


    @Override

    public void run() {

        System.out.println("download file");

        for (int i = 1; i <= 10; i++) {


            try {

                sleep(1000);


            } catch (InterruptedException e) {

                System.out.print(System.lineSeparator());

                e.printStackTrace();

            }
            try {

                sleep(1000);

                cdl.countDown();


            } catch (InterruptedException e) {

            }

        }

        System.out.println("download end ");

        super.run();


    }

}