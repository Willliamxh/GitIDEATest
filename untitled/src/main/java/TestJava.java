import javax.sound.midi.Soundbank;
import java.util.*;

public class TestJava {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75f,true);
        map.put("星期一", 40);
        map.put("星期二", 43);
        map.put("星期三", 35);
        map.put("星期四", 55);
        map.put("星期五", 45);
        map.put("星期六", 35);
        map.put("星期日", 30);

        System.out.println(map);
        map.get("星期四");
        System.out.println(map);
        String a;

    }

}
