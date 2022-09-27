package tcp;

import java.util.HashMap;

public class Time {
    public static void main(String[] args) {
        System.out.println(new Time().getTime());
    }

    public HashMap<String, String> getTime() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("date", java.time.LocalDate.now().toString());
        hashMap.put("time", java.time.LocalTime.now().toString());
        return hashMap;

    }
}
