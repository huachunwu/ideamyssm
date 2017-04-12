package com.accp.util;

import java.util.UUID;

/**
 * Created by admin on 2017/4/10.
 */
public class Util {
   //返回uuid
    public String getuuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
