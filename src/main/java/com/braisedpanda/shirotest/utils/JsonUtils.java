package com.braisedpanda.shirotest.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;


public class JsonUtils {

    /**
     *
     * @param resultType  设置状态码和相关信息。状态码0表示操作成功，其它值表示操作失败
     * @param count       原始集合对象的总数
     * @param list        传入的对象集合
     * @return            返回值是已经分页好的JSON对象
     */

    public static JSONObject createResultJson(ResultType resultType,int count,List list){

        JSONObject resultJson =new JSONObject();

        if(resultType!=null){

            resultJson.put("code",resultType.getResultCode());

            resultJson.put("msg",resultType.getResultMsg());
        }

        resultJson.put("count",count);

        resultJson.put("data",list);

        return resultJson;

    }

    public static JSONObject createResultJson(ResultType resultType){

        JSONObject resultJson =new JSONObject();

        if(resultType!=null){

            resultJson.put("code",resultType.getResultCode());

            resultJson.put("msg",resultType.getResultMsg());
        }


        return resultJson;

    }


}
