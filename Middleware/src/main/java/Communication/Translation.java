package Communication;

import lombok.Data;
import java.net.URLEncoder;


/**
 * @author snow create 2021/04/10 10:10
 */
@Data
public class Translation {
    private static String to = "zh";
    private static String from = "auto";
    private static final String randomCode = "38350220";
    private static final String APP_ID = "20210410000770673";
    private static final String SECURITY_KEY = "27vKe8PZ6i90zxd3RpEp";
    private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    /**
     * 调用百度翻译API进行翻译
     * @author create 2021/04/10 13:48
     * @param content
     * @return
     */
    public static TranslateResult translate(String content){
        String sign = MD5.md5(APP_ID + content + randomCode + SECURITY_KEY);
        try {
            content = URLEncoder.encode(content, "utf8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String param = "q=" + content + "&from=" + from + "&to=" + to + "&appid=" + APP_ID + "&salt=" + randomCode + "&sign=" + sign;
        return new TranslateResult(HttpRequest.sendGet(url, param));
    }

}
