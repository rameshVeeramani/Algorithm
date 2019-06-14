import java.beans.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SerializationBomb {

    public static void main(String []args){

        Set<Object>  root = new HashSet<>();
        Set<Object>  firstChild = root;
        Set<Object>  secondChild = new HashSet<>();

        for(int i =0; i <= 100 ; i++){
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();

            firstChild.add(t1);
            firstChild.add(t2);

            secondChild.add(t1);
            secondChild.add(t2);

        }
        //return serialize(root);

    }
}

class someData implements Serializable {
    private static final long serialversionUID = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    // Default constructor
    public someData(String name, int age, int a, int b)
    {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }
}
