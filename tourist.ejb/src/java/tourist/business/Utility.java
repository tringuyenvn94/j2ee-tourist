/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class Utility {
    
    public static final Integer pagesize=10;
    public static final Integer pagesizeadmin=10;
    public static final String basepath="http://localhost:8080/tourist.com";

    /*
     * Datetime convert
     */
    public static Long parseDateToLong(){
        Date date=new Date();
        Long time=(Long)date.getTime();
        return time;
    }
    public static Long parseDateToLong(Date date){
        Long time=(Long)date.getTime();
        return time;
    }
    public static Long parseDateToLong(String day,String month,String year){
        Date date;
        DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sdate=new StringBuilder();

        try{
            Integer.valueOf(day);
            sdate.append(day).append("/");
        }catch(Exception ex){
            sdate.append(1).append("/");
        }
        try{
            Integer.valueOf(month);
            sdate.append(month).append("/");
        }catch(Exception ex){
            sdate.append(1).append("/");
        }
        try{
            Integer.valueOf(year);
            sdate.append(year);
        }catch(Exception ex){
            sdate.append(1970);
        }
        try{
            date=(Date)dateformat.parse(sdate.toString());
        }catch(ParseException pex){
            date=new Date();
        }

        return (Long)date.getTime();
    }
    public static String parseDateToString(String format){
        Date date=new Date();
        DateFormat dateformat=new SimpleDateFormat(format);//("dd/MM/yyyy");
        return dateformat.format(date);
    }
    public static String parseDateToString(Long time,String format){
        Date date=new Date();
        date.setTime(time);
        DateFormat dateformat=new SimpleDateFormat(format);//("dd/MM/yyyy");
        return dateformat.format(date);
    }
    public static String parseDateToString(Date date,String format){
        DateFormat dateformat=new SimpleDateFormat(format);//("dd/MM/yyyy");
        return dateformat.format(date);
    }
}
