package com.example.iotproject.savitar;

/**
 * Created by sunil on 17/11/16.
 */
import java.util.*;
public class Record {

    Properties member = new Properties();

    public void setValue(String uname,String pass)

    {
        member.put(uname, pass);
    }
    public String getValue(String uname) {
        String s = member.getProperty(uname);
        return s;
    }
}
