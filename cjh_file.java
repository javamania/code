import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class cjh_file {
    public static void main(String[] args) throws IOException {
        File dir = new File("C:/dev/trend/code/Google Cloud Next");
        File files[] = dir.listFiles();
        File newFile = new File("cjh_out.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile) );
        for (int i = 0; i < files.length; i++) {
      //      System.out.println("file: " + files[i]);
            String temp = null;
            if ( files[i].getName().endsWith("txt")) {
                BufferedReader br = new BufferedReader(new FileReader(files[i]));
                while((temp = br.readLine() ) != null) {
                    temp = temp.trim();
                    if ( temp.length() != 0 ) {
                        String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
                        temp = temp.replaceAll(match, " ");
                        System.out.println(temp);
                        bw.write(temp);

                    }
                }
            }
        }

        
        bw.close();
    }
}