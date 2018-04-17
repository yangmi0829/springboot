package com.example.demo.Tool;

import com.example.demo.entity.MailEntity;

import java.util.List;

/**
 * Created by ym on 2017/11/13 0013.
 */
public class MailUtils {
    private static MailEntity mailEntity = new MailEntity();

    /**
     * 设置标题
     *
     * @param title
     * @return
     */
    public MailUtils title(String title) {
        mailEntity.setTitle(title);
        return this;
    }

    /**
     * 设置发件内容
     *
     * @param content
     * @return
     */
    public MailUtils content(String content) {
        mailEntity.setContent(content);
        return this;
    }

    /**
     * 设置收件人集合
     *
     * @param list
     * @return
     */
    public MailUtils send(List<String> list) {
        mailEntity.setReceiveList(list);
        return this;
    }

}
