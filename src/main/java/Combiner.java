import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yashasvi on 3/6/15.
 */
public class Combiner {


    public Combiner() {

    }

    private List<String> getFileContent(String file) throws IOException {
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> content = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.add(line);
        }
        bufferedReader.close();

        return content;
    }

    private List<String> getLogicContent(String file1, String file2,int limit) throws IOException {
        List<String>contentList= new ArrayList<String>();
        List<String>randomContentList= new ArrayList<String>();


        for (String content1 : getFileContent(file1)) {
            for (String content2 : getFileContent(file2))
                contentList.add(content1 + "," + content2 );
        }

        Collections.shuffle(contentList);

            for(int i=0; i<limit;i++) {
            randomContentList.add(contentList.get(i));
        }
        return  randomContentList;

    }



    public List<Path> and(List<Path> pathList1, List<Path> pathList2, int limit) throws IOException {
        List<Path> pathList = new ArrayList<Path>();

        Path path = Paths.get("src/main/resources/And.txt");
        Path complementPath = Paths.get("src/main/resources/AndComplement.txt");
        File andFile = new File(path.toString());


        if (!andFile.exists()) {

            andFile.createNewFile();
        }
        FileWriter fw1 = new FileWriter(andFile.getAbsoluteFile());
        BufferedWriter bw1 = new BufferedWriter(fw1);

        for(String content:getLogicContent(pathList1.get(0).toString(), pathList2.get(0).toString(),limit))
        {
        bw1.write(content+"\n");
        }

        bw1.close();

        File andFileComplement = new File(complementPath.toString());

        if (!andFileComplement.exists()) {

            andFileComplement.createNewFile();
        }
        FileWriter fw2 = new FileWriter(andFileComplement.getAbsoluteFile());
        BufferedWriter bw2 = new BufferedWriter(fw2);

        for(String content:getLogicContent(pathList1.get(1).toString(), pathList2.get(1).toString(),limit/3))
        {
            bw2.write(content+"\n");
        }

        for(String content:getLogicContent(pathList1.get(0).toString(), pathList2.get(1).toString(),limit/3))
        {
            bw2.write(content+"\n");
        }

        for(String content:getLogicContent(pathList1.get(1).toString(), pathList2.get(0).toString(),limit-limit/3-limit/3))
        {
            bw2.write(content+"\n");
        }



        bw2.close();

        pathList.add(path);
        pathList.add(complementPath);

        return pathList;


    }

    public List<Path> or(List<Path> pathList1, List<Path> pathList2, int limit) throws IOException {
        List<Path> pathList = new ArrayList<Path>();
        Path path = Paths.get("src/main/resources/Or.txt");
        Path complementPath = Paths.get("src/main/resources/OrComplement.txt");

        File orFile = new File(path.toString());

        if (!orFile.exists()) {

            orFile.createNewFile();
        }
        FileWriter fw1 = new FileWriter(orFile.getAbsoluteFile());
        BufferedWriter bw1 = new BufferedWriter(fw1);

        for(String content:getLogicContent(pathList1.get(0).toString(), pathList2.get(0).toString(),limit/3))
        {
            bw1.write(content+"\n");
        }

        for(String content: getLogicContent(pathList1.get(0).toString(), pathList2.get(1).toString(),limit/3))
        {
            bw1.write(content+"\n");
        }

        for(String content:getLogicContent(pathList1.get(1).toString(), pathList2.get(0).toString(),limit-limit/3-limit/3))
        {
            bw1.write(content+"\n");
        }


        bw1.close();

        File orFileComplement = new File(complementPath.toString());

        if (!orFileComplement.exists()) {

            orFileComplement.createNewFile();
        }
        FileWriter fw2 = new FileWriter(orFileComplement.getAbsoluteFile());
        BufferedWriter bw2 = new BufferedWriter(fw2);

        for(String content:getLogicContent(pathList1.get(1).toString(),pathList2.get(1).toString(),limit))
        {
            bw2.write(content+"\n");
        }


        bw2.close();
        pathList.add(path);
        pathList.add(complementPath);

        return pathList;

    }


}
