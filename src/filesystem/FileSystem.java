/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    
    public FileSystem() {       
        metadata = new Metadata();
    }
    
    public void getMetadata(File file) {
        String strCreationDate,
                strModificationDate,
                strQtyOfFiles;
        int totalOfFilesRead = 0;
        
        /*retrieve header data
        format: dateOfCreation|dateOfModification|quantityOfFileThisFileHolds
                fileName|originalPath|dateOfCreation|dateOfModification|extention@
        
        */
        try {
            InputStream is = new FileInputStream(file);
            
            //retrieve creation date
            strCreationDate = readData(is, metadata.getString_Split());
            System.out.println("Creation date " + strCreationDate);
            metadata.setCreationDate(strCreationDate);
            //retrieve modification date
            strModificationDate = readData(is, metadata.getString_Split());
            System.out.println("Modification date " + strModificationDate);
            metadata.setModificationDate(strModificationDate);
            //retrieve quantity of files
            strQtyOfFiles = readData(is, metadata.getString_Split());
            System.out.println("Quantitu of files " + strQtyOfFiles);
            metadata.setQtyOfFiles(Integer.parseInt(strQtyOfFiles));
            
            
            
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
     */
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
}
