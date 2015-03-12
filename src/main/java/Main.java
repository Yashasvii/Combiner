import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashasvi on 3/6/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Combiner combiner= new Combiner();
        List<Path> paths1= new ArrayList<Path>();
        List<Path> paths2= new ArrayList<Path>();
        paths1.add(Paths.get("src/main/resources/name.csv"));
        paths1.add(Paths.get("src/main/resources/complementname.csv"));
        paths2.add(Paths.get("src/main/resources/last.csv"));
        paths2.add(Paths.get("src/main/resources/complementlast.csv"));

        System.out.println(combiner.and(paths1, paths2,6));
        System.out.println( combiner.or(paths1,paths2,7));


    }


}
