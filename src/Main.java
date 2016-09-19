import org.apache.commons.codec.binary.Base64;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Main menu");
            System.out.println("1 - Encoding/Decoding String");
            System.out.println("2 - Encoding/Decoding File");
            System.out.println("0 - Exit");
            String ch = bufferedReader.readLine();
            switch (ch) {
                case "1":

                    String str;
                    byte[] data;
                    System.out.println("Input string:");
                    str = bufferedReader.readLine();
                    str = Base64.encodeBase64String(str.getBytes());
                    //str = Base64.encode(str.getBytes());
                    System.out.println("Encoded string: " + str);
                    data = Base64.decodeBase64(str);
                    System.out.println("Decoded string: " + new String(data));
                    break;
                case "2":
                    byte[] encodedData;
                    String file_enc = "";
                    System.out.println("Plese, input file path:");
                    String path = bufferedReader.readLine();
                    File file = new File(path);
                    int len = (int)file.length();
                    if(file.exists()){
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
                        data = new byte[len];
                        bis.read(data,0,len);
                        bis.close();
                        encodedData = Base64.encodeBase64(data);

                        //System.out.println(file_enc);

                        byte[] decodedData;

                        decodedData = Base64.decodeBase64(encodedData);
                        File f = new File("downloaded");
                        f.createNewFile();
                            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()));
                            if (decodedData.length == 0) {
                                System.out.println("empty");
                            }
                            bos.write(decodedData);
                            bos.flush();
                            bos.close();
                            //C:\Users\Vadim\Desktop\splash17.jpg
                        }
                    else{
                        System.err.println("File not found");
                    }


                    break;
                case "0":
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Wrong key");
            }

        }
    }
}
