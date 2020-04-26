package backendproj.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class testDoc {
    @Id
    private String id ;
    private String msg;

    public testDoc(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }
    public testDoc() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
