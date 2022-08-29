package my.study.durtimeblog.utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
    public static List<Integer> stringTolist(String s){
        List<Integer> integers=new ArrayList<>();
        String[] split = s.split(",");
        for (String s1:split){
            if (!s1.equals("")){
                integers.add(Integer.parseInt(s1));
            }
        }
        return integers;
    }
}
