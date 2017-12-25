package com.springsecurity.Wrapper;

import org.apache.catalina.servlet4preview.http.HttpServletRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ParameterRequestWrapper extends HttpServletRequestWrapper{
    private Map<String, String[]> parameterMap;
    public ParameterRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
    }
   /* //重载一个构造方法
    public ParameterRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
        this(request);
        addAllParameters(extendObject);//这里将扩展参数写入参数表
    }
*/
    @Override
    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
       /* String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }*/

        String[] s = parameterMap.get("name");
        if(s != null && s.length == 0){
            System.out.println(s);
            return "123";
        }
        return "213";
    }

    public String[] getParameterValues(String name) {//同上
       /* String[] bb = parameterMap.get("name");
        for(String n : bb) {
            System.out.println(n);
        }
        String[] s = {"dddd"};*/
        String bb = parameterMap.get("name")[0];
        if(bb.contains("（") ||  bb.contains("）")){
            bb = bb.replaceAll("（", "(");
            bb = bb.replaceAll("）",")");
        }
        return new String[]{bb};

    }

   /* public void addAllParameters(Map<String , Object>otherParams) {//增加多个参数
        for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
            addParameter(entry.getKey() , entry.getValue());
        }
    }*/


    /*public void addParameter(String name , Object value) {//增加参数
        if(value != null) {
            if(value instanceof String[]) {
                params.put(name , (String[])value);
            }else if(value instanceof String) {
                params.put(name , new String[] {(String)value});
            }else {
                params.put(name , new String[] {String.valueOf(value)});
            }
        }
    }*/
}
