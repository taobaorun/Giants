package com.jiaxy.giants.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * </p>
 *
 * @since 2015/05/29 17:02
 */
public class GenericBean<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static void main(String[] args){
        GenericBean<Student> genericBean = new GenericBean<Student>();
        genericBean.setData(new Student("test"));
        String str = JSONObject.toJSONString(genericBean, SerializerFeature.WriteClassName);
        System.out.println(str);

        GenericBean genericBean1 = JSONObject.parseObject(str,GenericBean.class);
        System.out.println(genericBean1.getData().getClass());
    }
}
