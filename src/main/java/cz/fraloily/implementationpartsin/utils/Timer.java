package cz.fraloily.implementationpartsin.utils;

import java.sql.Timestamp;

public class Timer {
    public static long millisecondsFromNow(Timestamp past) {
       return Timer.getCurrentTime().getTime() - past.getTime();
    }

    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

}
