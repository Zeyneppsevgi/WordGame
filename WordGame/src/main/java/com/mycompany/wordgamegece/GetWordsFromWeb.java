/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordgamegece;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author zeynepsevgi
 */
public class GetWordsFromWeb {
    public static void main(String [] args ){
        String url= "https://kelimeler.xyz/7-harfli-kelimeler";
        File currentDirFile = new File(".");
        
        try{
            Document doc =Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            List<String> results= links.eachText();
            
            List<Integer>removedIndices=IntStream.range(0,13)
                    .boxed().collect(Collectors.toList());
            
            for(int i= 1; i<4 ;i++){
                removedIndices.add(results.size()-i);   
            }
            removedIndices
                    .stream().sorted(Comparator.reverseOrder())
                    .forEach(i->results.remove(i.intValue()));
            
            Path path=Paths.get(currentDirFile.getAbsolutePath() + "/words.txt");
            Files.write(path,results);
            
            //System.out.println(results);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            
        }
        
        
            
       
        
      
    }

   
    
}
