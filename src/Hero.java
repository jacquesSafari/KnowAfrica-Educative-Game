
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safari
 */
public class Hero {
    String fullname;
    Date dob;
    Date deceased;
    String photoURL;
    String countryID;
    String comments;

    public Hero() {
    }


   /**
    * 
    * @param fullname
    * @param dob
    * @param deceased
    * @param photoURL
    * @param countryID 
    */
    public Hero(String fullname, Date dob, Date deceased, String photoURL, String countryID) {
        this.fullname = fullname;
        this.dob = dob;
        this.deceased = deceased;
        this.photoURL = photoURL;
        this.countryID = countryID;
    }
    public Hero(String fullname,String photoURL, String countryID) {
        this.fullname = fullname;
        this.photoURL = photoURL;
        this.countryID = countryID;
    }

    /**
     *
     * @param fullname
     * @param photoURL
     * @param countryID
     * @param comments
     */
    public Hero(String fullname,String photoURL, String countryID, String comments) {
        this.fullname = fullname;
        this.photoURL = photoURL;
        this.countryID = countryID;
        this.comments=comments;
    }
    
    
    
   public Hero(String name, Date dob) {
        this.fullname = name;
        this.dob = dob;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

      
    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setDeceased(Date deceased) {
        this.deceased = deceased;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getDob() {
        return dob;
    }

    public Date getDeceased() {
        return deceased;
    }

    public String getPhotoURL() {
        return photoURL;
    }
    
    public static Date formatDate(String date){
       DateFormat df= DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        try {
            return df.parse("16/1/1961");
//        SimpleDateFormat sd=new SimpleDateFormat();
//        return sd.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
