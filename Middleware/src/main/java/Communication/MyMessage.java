package Communication;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author snow create 2021/04/07 20:34
 *            modified 2021/04/10 14:21
 */
@Data
public class MyMessage implements Serializable {
    private Boolean file;
    private Boolean group;
    private String time;
    private String content;
    final private String senderId;
    private String receiverId;
    final private DateTimeFormatter dateTimeFormatter;

    public MyMessage(String id){
        this.senderId = id;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss ");
    }
    public void setMessage(Boolean translate, Boolean file, Boolean group, String content, String receiverId){
        this.file = file;
        this.group = group;
        this.content = (translate?Translation.translate(content).getDst().get(0):content);
        this.receiverId = receiverId;
        this.time = LocalDateTime.now().format(dateTimeFormatter);
    }

    public String getMessage(){
        if(file){
            readFile();
            return time + senderId + " send a file '" + content + "' to " + receiverId + "\n";
        }
        else {
            System.out.println(time + senderId + (group?(" in " + receiverId):"") + " : " + content);
            return time + senderId + (group?(" in " + receiverId):"") + " : " + content + "\n";
        }
    }

    public String readFile(){
        String fileName = this.content.substring(this.content.lastIndexOf("\\")+1);
        System.out.println(fileName);
        return fileName;
    }

    public String getReceiverId() {
        return (group?"G_":"B_") + receiverId;
    }

}
