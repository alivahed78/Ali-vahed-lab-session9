package ceit.aut.ac.ir.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";
    
    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) throws Exception{
        //TODO: Phase1: read content from file
         file = new File("C:\\Users\\Ali\\Desktop\\ceit\\notes\\hello world example.txt"); 
         BufferedReader br = new BufferedReader(new FileReader(file));
         
         String st; 
  while ((st = br.readLine()) != null) 
    System.out.println(st);
        return "";
 }
    
    public static void fileWriter(String content) throws Exception {
        String fileName = getProperFileName(content);

        FileWriter myWriter = new FileWriter(fileName);
      myWriter.write("Hellooo");
      PrintWriter p = new PrintWriter(myWriter);
      p.print(content);
      myWriter.close();
        
    }

    //TODO: Phase1: define method here for reading file with InputStream
    public void read(){
   File file = new File("smthing.txt");
 
        try (InputStream in = new FileInputStream(file)) {
            int content;
            while ((content = in.read()) != -1) {
                System.out.print((char)content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    //TODO: Phase1: define method here for writing file with OutputStream
    public void write(){
        File file = new File("c:/newfile.txt");
        String content = "This is the text content";

        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public void write(String content) throws FileNotFoundException, IOException{
        String fileName = "hello world example.txt";

        try (FileInputStream fis = new FileInputStream(fileName)) {

            int i; 
            
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        }        
        
        System.out.println();
    }


    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
