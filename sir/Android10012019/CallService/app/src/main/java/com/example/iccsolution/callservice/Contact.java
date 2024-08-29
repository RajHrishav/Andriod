package com.example.iccsolution.callservice;

public class Contact {
    private String name;
    private String emailid;
    private String mobile;
    public Contact()
    {

    }

    public Contact (String name,String emailid,String mobile)
    {
        this.name=name;
        this.emailid=emailid;
        this.mobile=mobile;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



}
