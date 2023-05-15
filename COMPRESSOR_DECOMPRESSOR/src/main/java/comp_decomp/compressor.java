/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author ANKIT CHANDRA
 */
public class compressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");

        GZIPOutputStream qzip = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            qzip.write(buffer,0,len);
        }

        qzip.close();
        fos.close();
        fis.close();
}
}
