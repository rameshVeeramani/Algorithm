import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThradConcurrent {

    public static final ConcurrentMap<String, String> c = new ConcurrentHashMap<>();

    public static void main (String []args){
        String  ret = c.putIfAbsent("ramesh","richest");
        ret = (ret ==null) ? "null" : ret;
        String ret2 = c.putIfAbsent("ramesh","greatest");
        System.out.println(ret + " " + ret2);
        System.out.println(intern("ramesh"));
    }

    public static String intern(String s){
        String ss = c.putIfAbsent(s,s);
        String ret = (ss == null) ? s : ss;
        return  ret;
    }
}
