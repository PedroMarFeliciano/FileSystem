/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;

/**
 *
 * @author Pedro Feliciano
 * @author Gustavo Cardoso
 * @author Ewerton Ademar
 * @author Luiz Otávio Bissiato
 */
class Metadata {
    
    private ArrayList<String> fileMetadata;
    private final int FILE_HEADER_SIZE = 6,
            SYSTEM_HEADER_SIZE = 4;
    private int qtyOfFiles;
    private String creationDate,
            modificationDate;
    private final String STRING_SPLIT = "|",
            LINE_END = "@";

    public Metadata() {
        fileMetadata = new ArrayList<>();
    }    

    public int getQtyOfFiles() {
        return qtyOfFiles;
    }

    public int getFILE_HEADER_SIZE() {
        return FILE_HEADER_SIZE;
    }

    public int getSYSTEM_HEADER_SIZE() {
        return SYSTEM_HEADER_SIZE;
    }
    
    public String getStringSplit() {
        return STRING_SPLIT;
    }
    
    public String getLineEnd() {
        return LINE_END;
    }
    
    public String getCreationDate(){
        return creationDate;
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
    
    public void setQtyOfFiles(int qtyOfFiles) {
        this.qtyOfFiles = qtyOfFiles;
    }
    
}
