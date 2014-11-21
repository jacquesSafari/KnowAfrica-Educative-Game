
import java.util.HashMap;
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
public class Question {
    private int level;
    private String randomCountryID;
    public static LinkedHashMap<String,Country> dataMapCountry=new LinkedHashMap(MainWindow.dataHashMap);
    public static LinkedHashMap<String,Hero> dataMapHero=new LinkedHashMap(MainWindow.dataHashMapHero);
    static HashMap<String, Integer> questionCountryStatus=new HashMap<>();
    static HashMap<String, String> questionHeroStatus=new HashMap<>();
    static int questionNumber;
    
    public Question(){}

    public Question(int level) {
        this.level = level;
        questionNumber++;
        if(level==2)
            randomCountryID=(String) dataMapHero.keySet().toArray()[getRandomNumberHero()];
        else
            randomCountryID=Country.getRandomCountryID();
    }
    
//    public static String randomCountryIDforHero(){
//        return 
//    }
    
    /**
     * Gets the name of the country concerned by the question and checks whether it has not been used in another question
     * @return 
     */
    private String getCountryName(){
        while(questionCountryStatus.containsKey(getRandomCountryID())){
            if(questionCountryStatus.get(getRandomCountryID())==getLevel()){
                setRandomCountryID(Country.getRandomCountryID());
                if(questionCountryStatus.size()==dataMapCountry.size()){
                    questionCountryStatus.clear();
                    return "You have tried with all african countries. Question Memory has been reseted";
                }
            }else
                break;
            
        }
        
//       if(questionCountryStatus.containsKey(randomCountryID)) 
//        randomCountryID=Country.getRandomCountryID();
//       else
        questionCountryStatus.put(getRandomCountryID(), getLevel());
        return dataMapCountry.get(getRandomCountryID()).getName();
    }
    
    private String getHeroName(){
        while(questionHeroStatus.containsKey(getRandomCountryID())){
            if(questionHeroStatus.get(getRandomCountryID()).equals(dataMapHero.get(getRandomCountryID()).getFullname())){
//                setRandomCountryID(Country.getRandomCountryID());
                setRandomCountryID((String) dataMapHero.keySet().toArray()[getRandomNumberHero()]);
                if(questionHeroStatus.size()==dataMapHero.size()){
                    questionHeroStatus.clear();
                    return "You have tried with all african heroes available. Question Memory has been reseted";
                }
            }else
                break;
            
        }
        
//       if(questionCountryStatus.containsKey(randomCountryID)) 
//        randomCountryID=Country.getRandomCountryID();
//       else
        System.out.println(" Country ID "+getRandomCountryID());
        questionHeroStatus.put(getRandomCountryID(), dataMapHero.get(getRandomCountryID()).getFullname());
        return dataMapHero.get(getRandomCountryID()).getFullname();
    }
    
    public static int getRandomNumber(HashMap myhashmap){
        Random rnd=new Random();
        int limitRandom=myhashmap.size()-1;
        int randomNumber=0;
    
         randomNumber=rnd.nextInt(limitRandom);
            
         return randomNumber;
    }
    public static int getRandomNumber(){
                    
         return getRandomNumber(dataMapCountry);
    }
    public static int getRandomNumberHero(){
                    
         return getRandomNumber(dataMapHero);
    }
    public String generateRandomQuestion(){
        String generatedQuestion="";
            switch(getLevel()){
                case 1 :
                    generatedQuestion=" Please Locate "+getCountryName();
                    break;
                case 2 :
//                    getCountryName();
                    //Check if the question this hero has been used before
                    generatedQuestion=" Please Associate this Hero to his Country of Origin :"+getHeroName();
                    
                    break;
               default:
                   generatedQuestion=" Error in Question : Level Out of Bound ";
            }
        return generatedQuestion;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the randomCountryID
     */
    public String getRandomCountryID() {
        return randomCountryID;
    }

    /**
     * @param randomCountryID the randomCountryID to set
     */
    public void setRandomCountryID(String randomCountryID) {
        this.randomCountryID = randomCountryID;
    }
}
