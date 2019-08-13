package org.taru.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Id���ɹ��ߣ�
 */
public class IdUtil {
    private static DateTimeFormatter
            formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /**
     * ��ȡUUID
     * @return
     */
    public static String   getUuid(){
        String  uuid =UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * ��ȡDateId ��ǰʱ����?
     * @return
     */
    public static String  getDateId(){
        LocalDateTime dateTime =LocalDateTime.now();
        String str =formatter.format(dateTime);
        return  str;

    }
    /**
     * ��ȡtLongTime ��ǰʱ��ĺ�����
     * @return
     */
    public static String  getLongTimeId(){
        long  longValue =System.currentTimeMillis();
        return  String.valueOf(longValue);

    }

}
