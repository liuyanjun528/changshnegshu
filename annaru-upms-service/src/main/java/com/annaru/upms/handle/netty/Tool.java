package com.annaru.upms.handle.netty;

public class Tool {
    public static String subRemoteAddr(String remoteAddr){
        if(null == remoteAddr){
            return null;
        }
        int sindex = remoteAddr.indexOf('/')+1;
        int eindex = remoteAddr.indexOf(':');
        return remoteAddr.substring(sindex,eindex);
    }
}
