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
 */
class Metadata {
    
    private ArrayList<String> fileMetadata;
    private final int TAMANHO_CABECALHO = 8;
    private int qtyOfFiles;
    private String creationDate,
            modificationDate;
    private final String STRING_SPLIT = "|";

    public Metadata() {
        fileMetadata = new ArrayList<>();
    }    
    
    public String getString_Split() {
        return STRING_SPLIT;
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
