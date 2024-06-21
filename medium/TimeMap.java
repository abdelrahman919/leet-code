package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private static class StampValue {
        String value;
        int stamp;

        public StampValue(String value, int stamp) {
            this.value = value;
            this.stamp = stamp;
        }
    }

    Map<String, List<StampValue>> map;


    public TimeMap() {
        map = new HashMap<>();
    }


    public void set(String key, String value, int timestamp) {
        //If key doesn't exist create new list otherwise update current one
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new StampValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<StampValue> stampValues = map.get(key);
        //If key in nonexistent then list is null
        //If timestamp < the smallest time stamp in list then it's not valid
        if (stampValues == null || timestamp < stampValues.get(0).stamp) {
            return "";
        }
        int l = 0;
        int r = stampValues.size() - 1;
        int m;
        //Since we eliminate the invalid time stamps earlier we can just use a regular bs
        while (l <= r) {
            m = (l + r) / 2;
            StampValue currentSV = stampValues.get(m);
            if (currentSV.stamp < timestamp) {
                l = m + 1;
            } else if (currentSV.stamp > timestamp) {
                r = m - 1;
            } else {
                break;
            }
        }
        //even if the "else" condition is not met that means its either higher than the biggest value
        //or higher than the smallest value in list so we make sure to update m
        m = (l + r) / 2;
        return stampValues.get(m).value;

    }


    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();

        // Method calls
        timeMap.set("ctondw", "ztpearaw", 1);
        timeMap.set("vrobykydll", "hwliiq", 2);
        timeMap.set("gszaw", "ztpearaw", 3);
        timeMap.set("ctondw", "gszaw", 4);
        System.out.println(timeMap.get("gszaw", 5)); // Expected to print the result of get
        System.out.println(timeMap.get("ctondw", 6)); // Expected to print the result of get
        System.out.println(timeMap.get("ctondw", 7)); // Expected to print the result of get
        System.out.println(timeMap.get("gszaw", 8)); // Expected to print the result of get
        System.out.println(timeMap.get("vrobykydll", 9)); // Expected to print the result of get
        System.out.println(timeMap.get("ctondw", 10)); // Expected to print the result of get
        timeMap.set("vrobykydll", "kcvcjzzwx", 11);
        System.out.println(timeMap.get("vrobykydll", 12)); // Expected to print the result of get
        System.out.println(timeMap.get("ctondw", 13)); // Expected to print the result of get
        System.out.println(timeMap.get("vrobykydll", 14)); // Expected to print the result of get
        timeMap.set("ztpearaw", "zondoubtib", 15);
        timeMap.set("kcvcjzzwx", "hwliiq", 16);
        timeMap.set("wtgbfvg", "vrobykydll", 17);
        timeMap.set("hwliiq", "gzsiivks", 18);
        System.out.println(timeMap.get("kcvcjzzwx", 19)); // Expected to print the result of get
        System.out.println(timeMap.get("ztpearaw", 20));


//                null,null,null,null,null,
//                "ztpearaw","gszaw","gszaw","ztpearaw","hwliiq",
//                "gszaw",null,"kcvcjzzwx","gszaw", "kcvcjzzwx",
//                null,null,null,null,"hwliiq","zondoubtib"

    }


}
