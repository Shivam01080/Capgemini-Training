package com.gal.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    private String wordToSearch;
    private FileProvider fileProvider;
    // Property Injection
    public void setWordToSearch(String wordToSearch) {
        this.wordToSearch = wordToSearch;
    }
    public void setFileProvider(FileProvider fileProvider) {
        this.fileProvider = fileProvider;
    }
    public Map<String,Integer> createMapResult() throws Exception {

        Map<String,Integer> result = new HashMap<>();

        List<File> files = fileProvider.getFiles();

        for(File file : files) {
            int count = 0;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null) {
                int index = 0;
                while((index = line.indexOf(wordToSearch, index)) != -1) {
                    count++;
                    index += wordToSearch.length();
                }
            }
            br.close();
            result.put(file.getName(), count);
        }
        return result;
    }
}