package com.example.root.tb_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17-2-24.
 * 保存数据内容的关键类，全场的数据全是用SharedPreferences的方式保存的
 */

public class SharedHelper {

    private Context mContext;

    public SharedHelper(){
    }

    public SharedHelper(Context mContext){
        this.mContext=mContext;
    }

    //存入单个数据
    public void save(String typeName,String userName){
        SharedPreferences sp=mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(typeName,userName);
        editor.commit();
        Toast.makeText(mContext,"信息修改成功",Toast.LENGTH_SHORT).show();
    }

    //读取单个数据
    public Map<String,String> read(String typeName){
        Map<String,String> data = new HashMap<String, String>();
        SharedPreferences sp=mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        data.put(typeName,sp.getString(typeName,""));
        return data;
    }

    //存入list数据,重复数据返回0，写入成功返回1；
    public int saveList(String typeName,String userName){
        SharedPreferences sp=mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        //判断typeName_size是否存在，不存在新建，初始为0，存在则加1；
        int size=sp.getInt(typeName+"_size",-1);
        if(size<0){
            editor.putInt(typeName+"_size",0);
        }
        size+=1;

        for(int i=0;i<size;i++){
            //判断写入信息是否重复
            if (userName.equals(read(typeName+"_"+i).get(typeName+"_"+i))){
//                Toast.makeText(mContext,"重复写入信息",Toast.LENGTH_SHORT).show();
                return 0;
            }
        }

        editor.putInt(typeName+"_size",size);
        editor.putString(typeName+"_"+size,userName);
        editor.commit();
        return 1;
//        Toast.makeText(mContext,"size信息写入成功",Toast.LENGTH_SHORT).show();
    }

    //读取list数据
    public void loadList(String typeName,List<String> list){
        list.clear();
        SharedPreferences sp=mContext.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        int size=sp.getInt(typeName+"_size",-1);
        if(size<0){
            //返回无数据
            editor.putInt(typeName+"_size",0);
//            for(int i=0;i<=8;i++){
//                list.add("没有内容");
//            }
        }else {
            for (int i = 0; i <= size; i++) {
                list.add(sp.getString(typeName + "_" + i, null));
            }
        }


    }
}
