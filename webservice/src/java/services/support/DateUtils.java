package services.support;

import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class DateUtils {
    
    public static Calendar String2Calendar(String date) {
        try {
            Calendar calendar = null;
            Date dateDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            calendar = Calendar.getInstance();
            calendar.setTime(dateDate);
            //calendar.getTime().toString()
            return calendar;
        } catch (ParseException ex) {
            return null;
        }
    }
}
