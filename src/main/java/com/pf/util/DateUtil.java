package com.pf.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static DateTimeFormatter _YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime getLocalDateTimeFromString(String dateString){
        return LocalDateTime.parse(dateString,_YYYYMMDDHHMMSS);
    }

}
