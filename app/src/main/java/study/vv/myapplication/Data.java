package study.vv.myapplication;

import java.util.List;

/**
 * Created by student2 on 20.04.18.
 */

public class Data {
    private Integer code;
    private String lang;
    private List<String> text = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
