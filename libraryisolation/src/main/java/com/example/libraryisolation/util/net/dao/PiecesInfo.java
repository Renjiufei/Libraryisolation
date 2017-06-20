package com.example.libraryisolation.util.net.dao;

import java.util.ArrayList;

/**
 * Created by zjt on 2017/6/20.
 * 数据解析
 */
public class PiecesInfo {
    public int count;
    public String errmsg;
    public String jver;
    public String link;
    public String st;
    public ArrayList<AwardInfo> sl;
    public class  AwardInfo{
        public int c;
        public String img;
        public String l;
    }

}
