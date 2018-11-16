/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newwebscrape;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
/**
 *
 * @author pacog
 */
public class NewWebScrape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String url=url();
        Element documento=scrape(url);
        paginas (documento);
        
    }
    public static String url(){
        final String search = "https://www.amazon.es/s/ref=nb_sb_noss_2?__mk_es_ES=ÅMÅŽÕÑ&url=search-alias%3Daps&field-keywords=";
        Scanner busqueda= new Scanner (System.in);
        System.out.println("Introduce busqueda: ");
        String keyword = busqueda.nextLine();
        String url = search+keyword;
        System.out.println("URL: "+url);
        return url;
    }
    public static Element scrape(String url) throws IOException{
        final Document document = Jsoup.connect(url).get();
            System.out.println(url);
            return document;
    }
    public static void paginas(Element document){
       
        if (document.select(".pagnNext").first()!=null){
            Element nextpag = document.select(".pagnNext").first();
            String next =nextpag.attr("href");
            System.out.println(next);
        } else {
            System.out.println("no hay paginas");
        }
    }
    public static void patrocinado(){
        
    }
    public static void EscribirCVS() throws IOException {
        String archCSV = "E:\\nuevo.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(archCSV));
        writer.close();// comentario
    }
}
