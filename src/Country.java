
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safari
 */
public class Country {
    String ISOcode;
    String tld;
    String name;
    String capitalCity;
    String phoneCode;
    Hero hero=new Hero();
    static HashMap<String,Integer> countryQuestionStatus=new HashMap<>();
    
    public Country() {
    }

    public Country(String ISOcode, String tld, String name, String capitalCity, String phoneCode, Hero hero) {
        this.ISOcode = ISOcode;
        this.tld = tld;
        this.name = name;
        this.capitalCity = capitalCity;
        this.phoneCode = phoneCode;
        this.hero = hero;
    }
//    public Country(String ISOcode, String tld, String name) {
//        this.ISOcode = ISOcode;
//        this.tld = tld;
//        this.name = name;
//    }
    public Country(String ISOcode, String name,String capitalCity) {
        this.ISOcode = ISOcode;
        this.name = name;
        this.capitalCity=capitalCity;
    }
    public Country(String ISOcode, String name) {
        this.ISOcode = ISOcode;
        this.name = name;
    }

    public void setISOcode(String ISOcode) {
        this.ISOcode = ISOcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getISOcode() {
        return ISOcode;
    }

    public String getName() {
        return name;
    }

    public String getTld() {
        return tld;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public Hero getHero() {
        return hero;
    }
   
    public static String getRandomCountryName(){
        String mycountry="";
        String countryID="";
       
            LinkedHashMap<String,Country> dataMap=new LinkedHashMap(MainWindow.dataHashMap);
            countryID=(String) dataMap.keySet().toArray()[Question.getRandomNumber()];
            System.out.println(" Total Size "+dataMap.size()+" Random n# "+Question.getRandomNumber());
            
            //adding the code to the question already generated to prevent repetition
            countryQuestionStatus.put(countryID, 1);
            
            mycountry=dataMap.get(countryID).getName();
        return mycountry;
    }
    public static String getRandomCountryID(){
//        String mycountry="";
        String countryID="";
       
            LinkedHashMap<String,Country> dataMap=new LinkedHashMap(MainWindow.dataHashMap);
            countryID=(String) dataMap.keySet().toArray()[Question.getRandomNumber()];
//            System.out.println(" Total Size "+dataMap.size()+" Random n# "+Question.getRandomNumber());
//            
//            //adding the code to the question already generated to prevent repetition
//            countryQuestionStatus.put(countryID, 1);
//            
//            mycountry=dataMap.get(countryID).getName();
        return countryID;
    }
   
 
    
}
