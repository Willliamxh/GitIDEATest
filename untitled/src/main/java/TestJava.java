import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestJava {
    public static long num(String s)
    {
        int length=s.length();
        char chars[]=s.toCharArray();
        Arrays.sort(chars);
        HashMap<Character,Integer> map=new HashMap();
        for(int i=0;i<chars.length;i++)
        {
            boolean flag=true;
            int num=1;
            while (flag){
                if(i+1<chars.length&&chars[i]!=chars[i+1]){
                    if(!(i+1<chars.length))
                    {
                        break;
                    }
                    i++;
                    num++;
                }else {
                    flag=false;
                    map.put(chars[i],num);
                }
            }
        }
        Collection<Integer> values=map.values();
        //求阶乘
        long pailieshu=getJC(length);
        for(int chushu:values)
        {
            pailieshu=pailieshu/getJC(chushu);
        }

        return pailieshu;
    }

    public static long getJC(int n)
    {
        long res=1;
        for(int i=0;i<n;i++){
            res=res*(n-i);
        }
        return res;
    }
    public static void main(String[] args) {
        String a="cc";
        String b="dd";
        String c="ccdd";
        String d=a+b;
        System.out.println(c==d);

    }
    public static long getJieChen(int num) {
        long result = 1;
        for (int i = 0; i < num; i++) {
            result = result * (num-i) ;
        }
        return result;
    }

}
