package Communication;

import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow create 2021/04/10 13:43
 */
@Data
public class TranslateResult {
    private String from;
    private String to;
    private List<String> dst;
    private List<String> src;

    /**
     * 解析百度翻译API返回的结果
     * @author snow create 2021/04/10 13:46
     * @param result
     */
    public TranslateResult(String result){
        try {
            JSONObject json = (JSONObject)(new JSONParser().parse(result));
            from = json.get("from").toString();
            to = json.get("to").toString();
            dst = new ArrayList<>();
            src = new ArrayList<>();
            JSONArray jsonArray = (JSONArray)(new JSONParser().parse(json.get("trans_result").toString()));
            for (Object o : jsonArray) {
                JSONObject object = (JSONObject) o;
                dst.add(object.get("dst").toString());
                src.add(object.get("src").toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
