package cn.yaspped.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**日期转换工具类
 * @author gms
 * @Version: 1.0
 * @date 2020/4/19 17:15
 */
public class DateUtils {
    /**
     * 日期转换成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String date2String(Date date, String patt){
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        String format = dateFormat.format(date);
        return format;
    }

    /**
     * 字符串转换成日期
     * @param string
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String string,String patt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patt);
        Date parse = dateFormat.parse(string);
        return parse;


    }
}
