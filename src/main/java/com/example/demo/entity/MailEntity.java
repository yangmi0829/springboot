package com.example.demo.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class MailEntity {
    //smtp服务器
    private String smtpService;
    //端口号
    private String smtpPort;
    //设置发件人
    private String sender;
    //设置发件口令
    private String smtpPwd;
    //设置邮件标题
    private String title;
    //设置邮件内容
    private String content;
    //设置收件人集合
    public  String       getSmtpService() {
        return smtpService;
    }public void         setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }public String       getSmtpPort() {
        return smtpPort;
    }public void         setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }public String       getSender() {
        return sender;
    }public void         setSender(String sender) {
        this.sender = sender;
    }public String       getSmtpPwd() {
        return smtpPwd;
    }public void         setSmtpPwd(String smtpPwd) {
        this.smtpPwd = smtpPwd;
    }public String       getTitle() {
        return title;
    }public void         setTitle(String title) {
        this.title = title;
    }public String       getContent() {
        return content;
    }public void         setContent(String content) {
        this.content = content;
    }public List<String> getReceiveList() {
        return receiveList;
    }public void         setReceiveList(List<String> receiveList) {
        this.receiveList = receiveList;
    }private List<String>receiveList;
}
