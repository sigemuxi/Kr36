package com.example.lenovo.kr36;

import java.util.List;

/**
 * Created by lenovo on 2016/5/10.
 */
public class Bean {
    public Bean() {
    }

    /**
     * code : 200
     * data : {"hot_words":["抹茶","巧克力","手机壳","情侣","杯子","手表","双肩包","钱包","手链","项链","雨伞","母亲节"],"placeholder":"快选一份礼物，送给亲爱的Ta吧"}
     * message : OK
     */

    private int code;
    private DataEntity data;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class DataEntity {
        /**
         * hot_words : ["抹茶","巧克力","手机壳","情侣","杯子","手表","双肩包","钱包","手链","项链","雨伞","母亲节"]
         * placeholder : 快选一份礼物，送给亲爱的Ta吧
         */

        private String placeholder;
        private List<String> hot_words;

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public void setHot_words(List<String> hot_words) {
            this.hot_words = hot_words;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public List<String> getHot_words() {
            return hot_words;
        }
    }
}
