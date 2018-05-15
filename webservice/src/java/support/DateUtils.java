package support;

import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class DateUtils {
    
    public static Calendar String2Calendar(String date, String pattern) {
        try {
            pattern = (pattern == null || pattern.equals("") ) ? "dd/MM/yyyy" : pattern;
            Calendar calendar = Calendar.getInstance();
            Date dateDate = new SimpleDateFormat(pattern).parse(date);
            calendar.setTime(dateDate);
            //calendar.getTime().toString()
            return calendar;
        } catch (ParseException ex) {
            return null;
        }
    }
}
