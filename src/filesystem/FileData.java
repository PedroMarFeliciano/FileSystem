/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

/**
 *
 * @author Pedro Feliciano
 */
public class FileData implements Comparable {
    private String name,
            creationDate,
            modificationDate,
            firstByte,
            size,
            extension;
    
    public FileData(String name, String creationDate, String modificationDate,
            String firstByte, String size, String extension) {
        this.name = name;
        this.creationDate = creationDate;
        this.extension = extension;
        this.modificationDate = modificationDate;
        this.size = size;
        this.firstByte = firstByte;
    }

    public int compareTo(Object fd) {
        return Integer.parseInt(this.firstByte) - 
                Integer.parseInt(((FileData) fd).firstByte);
    }

    public String getFirstByte() {
        return firstByte;
    }

    public String getSize() {
        return size;
    }   
}
