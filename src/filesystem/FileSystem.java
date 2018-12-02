/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Feliciano
 */
public class FileSystem {
    
    private Metadata metadata;
    private final int BUFFER_SIZE = 8192; //8 KB
    
    Date date = new Date();
    SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    
    public FileSystem() {       
        metadata = new Metadata();
    }
    
    public void createFile(String fileName) {
        String creationDate = sdf.format(date.getTime());
        
        try {
            OutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(fileName));
            
            String fileHeader = creationDate+"|"+creationDate+"|"+"0|8@";
            
            outputStream.write(fileHeader.getBytes());
            outputStream.close();
            
        } catch (FileNotFoundException ex) {
            //adicionar tratamento de erro aqui.
        } catch (IOException ex) {
            //adicionar tratamento de erro aqui.
        }
        
    }
    
    public void insertFile() {
        
    }
    
    /*
    public void getMetadata(File file) {
        String strCreationDate,
                strModificationDate,
                strQtyOfFiles;
        int totalOfFilesRead = 0;
        
        try {
            InputStream is = new FileInputStream(file);
            
            
            
            is.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
       
    }
    
    public void insertFile(File file) {
       
 
        try (
                
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Pedro Feliciano\\Documents\\Universidade de Coimbra\\Programação Orientada aos Objectos\\copia_teste.pedro");
        ) {
 
            byte[] buffer = new byte[BUFFER_SIZE];
 
            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "", 
                    "Erro ao gravar o arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Read and retrieve all the data before the next split
     * @param is
     * @return string with data contained before the next split
     
    public String readData(InputStream is, String split) {        
        byte[] buffer = new byte[1];
        String ret = "";
        
        try {
            while (is.read(buffer) != -1) {
                String tmp = new String(buffer);
                
                if (tmp.equals(split)) break;
                
                ret += tmp;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
        return ret;
    }
    */
}
