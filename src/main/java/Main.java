import java.io.IOException;

/**
 * Created by yashasvi on 3/6/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Combiner combiner= new Combiner();
      System.out.println(combiner.and("/home/yashasvi/combiner/src/main/resources/name.csv", "/home/yashasvi/combiner/src/main/resources/last.csv"));
        for(String s:combiner.or("/home/yashasvi/combiner/src/main/resources/name.csv","/home/yashasvi/combiner/src/main/resources/last.csv","/home/yashasvi/combiner/src/main/resources/complementname.csv","/home/yashasvi/combiner/src/main/resources/complementlast.csv"))
        {
            System.out.println(s);
        }

    }


}
