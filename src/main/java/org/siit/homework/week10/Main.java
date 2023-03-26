package org.siit.homework.week10;

public class Main {

    public static void main(String[] args) {

        Gate gate = new Gate();

        Runnable statisticsRunnable = new StatisticsThread(gate);
        Thread statisticsThread = new Thread(statisticsRunnable);
        statisticsThread.start();

        for (int i = 0; i < StatisticsThread.MAX_CAPACITY; i++) {

            Runnable attendeeRunnable = new AttendeeThread(gate);
            Thread attendeeThread = new Thread(attendeeRunnable);

            attendeeThread.start();

            try {
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
