package com.meiwufang.mm.maker.json;

/**
 * Created by linhomhom on 14-12-31.
 */
public class Jsonable {

    public String toJson() {
        return Jsoner.getInstance().toJson(this);
    }

}
