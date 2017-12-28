package com.springsecurity.Wrapper;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Te {
    public static void main(String[] args) {

        MessageDigestPasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("MD5");
        String pass = passwordEncoder.encodePassword("mm",null);
        System.out.println(pass);

        boolean b = passwordEncoder.isPasswordValid(pass,"mm",null);
        System.out.println(b);
        List<String> list = new ArrayList();
        Util.add(list);
        for(String s : list){
            System.out.println(s);
        }

        Map<String, String> map = new HashMap<>();
        System.out.println(map.keySet());
        for(String s : map.keySet()){
            System.out.println(s);
        }
    }
    public static class Util{
        public static List<String> add(List<String> list){
            list.add("papap");
            list.add("3333");
            return list;
        }
    }
}

