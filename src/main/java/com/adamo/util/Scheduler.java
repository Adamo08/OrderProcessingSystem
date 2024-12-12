package com.adamo.util;

import com.adamo.service.FileService;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {

    private final FileService fileService = new FileService();
    public void startReadingOrdersEveryHour() {
        Timer timer = new Timer();
        TimerTask readOrdersTask = new TimerTask() {
            @Override
            public void run() {
//                System.out.println("Scheduler triggered at: " + new java.util.Date());
                String filePath = "src/main/java/com/adamo/resources/data/orders.json";
                fileService.readOrdersFromFile(filePath);
            }
        };
        // Schedule the task to run every hour
        timer.scheduleAtFixedRate(readOrdersTask, 0, 3600 * 1000); // 3600 * 1000 ms = 1 hour
    }


}