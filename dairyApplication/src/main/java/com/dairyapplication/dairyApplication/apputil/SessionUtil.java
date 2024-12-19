package com.dairyapplication.dairyApplication.apputil;

import java.time.LocalTime;

public class SessionUtil {
    /**
     * Determines whether the current time falls in the morning or evening session.
     *
     * @return "morning" or "evening"
     */
    public static String getCurrentSession() {
        LocalTime now = LocalTime.now();

        // Define time ranges for sessions
        LocalTime morningStart = LocalTime.of(4, 0);
        LocalTime morningEnd = LocalTime.of(11, 59);
        LocalTime eveningStart = LocalTime.of(17, 0);
        LocalTime eveningEnd = LocalTime.of(22, 59);

        if (now.isAfter(morningStart) && now.isBefore(morningEnd.plusSeconds(1))) {
            return "morning";
        } else if (now.isAfter(eveningStart.minusSeconds(1)) && now.isBefore(eveningEnd.plusSeconds(1))) {
            return "evening";
        } else {
            throw new IllegalArgumentException("Current time does not fall in any defined session.");
        }
    }
}
