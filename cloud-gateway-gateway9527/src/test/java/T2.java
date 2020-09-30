import java.time.ZonedDateTime;

/**
 * description: T2 <br>
 * date: 2020/9/30 14:53 <br>
 * author: sttdev <br>
 * version: 1.0 <br>
 */
public class T2 {
    public static void main(String[] args) {
        //获取网关路由的断言中匹配时间的对象ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
