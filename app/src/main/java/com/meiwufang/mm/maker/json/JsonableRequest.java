package com.meiwufang.mm.maker.json;

/**
 * Created by linhomhom on 14-12-31.
 */
public class JsonableRequest extends Jsonable{
    public String svr_name;//服务器名字
    public String req_num;//请求流水号
    public String sess_id;//会话id
    public String dev_id;//设备id
    public String sys_type;//设备系统类型 android = d900102
    public String cl_ver;

    @Override
    public String toString() {
        return "svr_name=" + svr_name + "&req_num=" + req_num +"&sess_id=" + sess_id
                + "&dev_id=" + dev_id + "&sys_type=" + sys_type + "&cl_ver=" + cl_ver;
    }
}
