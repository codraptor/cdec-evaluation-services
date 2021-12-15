package com.cdec.validator.utils;

import java.sql.Timestamp;
import java.util.Date;

public class TimeUtil {

    public static Timestamp getCurrentTimeStamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }


}
