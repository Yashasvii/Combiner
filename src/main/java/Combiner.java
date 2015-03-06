import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashasvi on 3/6/15.
 */
public class Combiner {
   private static Integer outputFileName=1;

    public  Combiner()
    {

    }

    private String[] getFileContent(String file) throws IOException {
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> content = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.add(line);
        }
        bufferedReader.close();

        return content.toArray(new String[content.size()]);

    }

    public String and(String file1, String file2) throws IOException {

    String file= "/home/yashasvi/combiner/src/main/resources/"+outputFileName.toString()+".txt";
        outputFileName++;

        File andFile= new File(file);

        if (!andFile.exists()) {
            andFile.createNewFile();
            FileWriter fw = new FileWriter(andFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String content1 : getFileContent(file1)) {
                for (String content2 : getFileContent(file2))
                    bw.write(content1 + "," + content2 + "\n");
            }
            bw.close();
        }
        return andFile.getAbsolutePath();


    }

    public String[] or(String file1, String file2, String complementFile1, String complementFile2) throws IOException {
        List<String> content = new ArrayList<String>();
       content.add(and(file1,file2));
        content.add(and(file1,complementFile2));
        content.add(and(complementFile1,file2));

        return content.toArray(new String[content.size()]);



    }






}
