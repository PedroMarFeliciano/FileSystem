/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
    private ArrayList<FileData> fileData;
    
    private Date date = new Date();
    private SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    private String contextFile = "";
    
    public FileSystem() {       
        metadata = new Metadata();
        fileData = new ArrayList<>();
    }
    
    public void createFile(String filePath) {
        
        String path = "";
        
        if (filePath.contains(".")) {
            String[] newFilePath = filePath.split("\\.");
            path = newFilePath[0] + ".dp"; 
        }
        else {
            path = filePath + ".dp";
        }       
        
        String creationDate = sdf.format(date.getTime());
        
        try {
            OutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(path));
            
            String fileHeader = creationDate+metadata.getStringSplit()+
                    creationDate+metadata.getStringSplit()+"0"+
                    metadata.getStringSplit()+metadata.getLineEnd();
            
            outputStream.write(fileHeader.getBytes());
            outputStream.close();
            
        } catch (FileNotFoundException ex) {
            //adicionar tratamento de erro aqui.
        } catch (IOException ex) {
            //adicionar tratamento de erro aqui.
        }
        
    }
    
    public void openFile(String filePath) {
        contextFile = filePath;
        String str = "",
                fileName = "",
                fileCreationDate = "",
                fileModificationDate = "",
                fileFirstByte = "",
                fileSize = "",
                fileExtension = "";
        int count = 0;                  //used to know which data we are fetching
        byte[] buffer = new byte[1];
        
        try {
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(contextFile));
            
            while (inputStream.read(buffer) != -1) {
                String aux = buffer.toString();
                
                if ("@".equals(aux)) break;
                
                str += aux;
                
                if ("|".equals(aux)) {
                    
                    switch(count) {
                        case 0:
                            metadata.setCreationDate(str);
                            break;
                        case 1:
                            metadata.setModificationDate(str);
                            break;
                        case 2:
                            metadata.setQtyOfFiles(Integer.parseInt(str));
                            break;
                    }
                    count++;
                    str = "";
                }
            }
            
            if (metadata.getQtyOfFiles() != 0) {
                
                for (int i = 0; i < metadata.getQtyOfFiles(); i++) {    
                    count = 0;
                    while (inputStream.read(buffer) != -1) {
                        
                        String aux = buffer.toString();
                        
                        if ("@".equals(aux)) break;
                        
                        str += aux;
                        
                        if ("|".equals(aux)) {
                            switch (count) {
                                case 0:
                                    fileName = str;
                                    break;
                                case 1:
                                    fileCreationDate = str;
                                    break;
                                case 2:
                                    fileModificationDate = str;
                                    break;
                                case 3:
                                    fileFirstByte = str;
                                    break;
                                case 4:
                                    fileSize = str;
                                    break;
                                case 5:
                                    fileExtension = str;
                                    break;
                            }
                            count++;
                            str = "";
                        }
                    }
                    
                    fileData.add(new FileData(fileName, fileCreationDate, 
                            fileModificationDate, fileFirstByte, fileSize, 
                            fileExtension));
                }
            }
            
            inputStream.close();
        } catch (FileNotFoundException ex) {
            //adicionar erro
        } catch (IOException ex) {
            //adicionar erro
        }
    }
    
    public void insertFile(String fileName) {
        /*
        1 - descobrir tamanho do arquivo que o usuario quer inserir - OK
        2 - descobrir melhor partição para inserir o arquivo
        3 - começar a criar o arquivo a partir do 1,5MB do sistema de arquivo
        */
        
        long fileSize; 
        
        if ("".equals(contextFile)) {
            JOptionPane.showMessageDialog(null, "É nessário abrir um arquivo.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        File file = new File(fileName);
        fileSize = file.length();
        
        //verificar utilizando os dados presente no arraylist de FileData
        Collections.sort(fileData);
    }
    
    public ArrayList<FileData> getFileData() {
        return fileData;
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
