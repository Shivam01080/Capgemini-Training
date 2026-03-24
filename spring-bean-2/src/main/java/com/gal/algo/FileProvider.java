package com.gal.algo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileProvider {

    private String dirToSearch;
    private String fileFilter;

    // Constructor Injection
    public FileProvider(String dirToSearch, String fileFilter) {
        this.dirToSearch = dirToSearch;
        this.fileFilter = fileFilter;
    }
    public List<File> getFiles() {
        File dir = new File(dirToSearch);
        File[] files = dir.listFiles();
        List<File> result = new ArrayList<>();
        if (files != null) {
            for (File f : files) {
                if (f.getName().endsWith(fileFilter)) {
                    result.add(f);
                }
            }
        }

        return result;
    }
}