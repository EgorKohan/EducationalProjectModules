package timer;

import lombok.SneakyThrows;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    private final TimerTask commonTimerTask = new TimerTask() {
        @SneakyThrows
        @Override
        public void run() {
            System.out.println("Start of run");
            Thread.sleep(3000);
            System.out.println("Hello");
        }
    };

    /**
     * Now, this performs the task after a certain delay, given as the second parameter of the schedule() method.
     * We'll see in the next section how to schedule a task at a given date and time.
     *
     * <b><br>Note that if we are running this is a JUnit test, we should add a Thread.sleep(delay * 2) call to allow the
     * Timer's thread to run the task before the Junit test stops executing.</b>
     */

    @SneakyThrows
    @Test
    public void afterAGivenDelay() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on: " + new Date() + "\n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer();
        long delay = 1000L;
        timer.schedule(timerTask, delay);
        System.out.println("ABOBA");
        Thread.sleep(delay * 2);
    }

    /**
     * If the Date has already been, then the task will perform right away
     */

    @Test
    public void atAGivenDateAndTime() throws InterruptedException {
        LocalDateTime twoSecondsLater = LocalDateTime.now().minusSeconds(2);
        Date twoSecondsLaterAsDate = Date.from(twoSecondsLater.atZone(ZoneId.systemDefault()).toInstant());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }, twoSecondsLaterAsDate);
        Thread.sleep(5000);
    }

    /**
     * <b>
     * A fixed delay means that execution will start a period of time after the
     * moment last execution started, even if it was delayed (therefore being itself delayed).
     * <br>
     * 0s     1s    2s     3s           5s
     * <br>
     * |--T1--|
     * <br>
     * |-----2s-----|--1s--|-----T2-----|
     * <br>
     * |-----2s-----|--1s--|-----2s-----|--T3--|
     * <br>
     * <br>
     * On the other hand, a fixed rate means that each execution will respect the initial schedule, no matter if a previous execution has been delayed.
     * <br>
     * 0s     1s    2s     3s    4s
     * <br>
     * |--T1--|
     * <br>
     * |-----2s-----|--1s--|-----T2-----|
     * <br>
     * |-----2s-----|-----2s-----|--T3--|
     * </b>
     */

    public static class NewsletterTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Email sent at: "
                    + LocalDateTime.ofInstant(Instant.ofEpochMilli(scheduledExecutionTime()),
                    ZoneId.systemDefault()));
        }
    }

    @SneakyThrows
    @Test
    public void scheduleARepeatableTaskWithAFixedDelay() {
        new Timer().schedule(new NewsletterTask(), 0, 1000); // That phenomenon is due to our decision to used fixed-delay repetition.

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
        }

    }

    @SneakyThrows
    @Test
    public void scheduleARepeatableTaskWithAFixedRate(){
        new Timer().scheduleAtFixedRate(new NewsletterTask(), 0, 1000);

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
        }
    }

    @Test
    public void scheduleADailyTask(){
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L;
        timer.scheduleAtFixedRate(commonTimerTask, delay, period);
    }

    /**
     * Will perform only one time
     */

    @SneakyThrows
    @Test
    public void cancelTheTimerTaskInsideRun(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on " + new Date());
                cancel();
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);
        Thread.sleep(1000L * 2);
    }

    @SneakyThrows
    @Test
    public void cancelTheTimer(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);

        Thread.sleep(1000L * 2);
        timer.cancel();
    }

    @SneakyThrows
    @Test
    public void stopTheThreadOfTheTimerTaskInsideRun(){
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
                Thread.currentThread().stop();
            }
        };

        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, 1000L, 1000L);
        Thread.sleep(1000L * 5);

    }

    /**
     * - Timer can be sensitive to changes in the system clock; ScheduledThreadPoolExecutor is not
     * <br>
     * - Timer has only one execution thread; ScheduledThreadPoolExecutor can be configured with any number of threads
     * <br>
     * - Runtime Exceptions thrown inside the TimerTask kill the thread, so following scheduled tasks won't run further;
     * with ScheduledThreadExecutor – the current task will be canceled, but the rest will continue to run
     */

    @SneakyThrows
    @Test
    public void usingOfExecutorServiceInsteadTheTimer(){
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + new Date());
            }
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(task, 1000L, 1000L, TimeUnit.MILLISECONDS);
        Thread.sleep(1000L * 3);
        executorService.shutdown();
    }

}
