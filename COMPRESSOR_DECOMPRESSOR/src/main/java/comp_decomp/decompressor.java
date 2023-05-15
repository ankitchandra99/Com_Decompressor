/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
/**
 *
 * @author ANKIT CHANDRA
 */
public class decompressor {
    
    String extension ;
     public static void method(File file,String p) throws IOException {
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);

        GZIPInputStream qzip = new GZIPInputStream(fis);
        
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/DecompressedFile."+p);

        
        
        byte[] buffer = new byte[1024];
        int len;
        while((len=qzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        qzip.close();
        fos.close();
        fis.close();

    }
   
}

