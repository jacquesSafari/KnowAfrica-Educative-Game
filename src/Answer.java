
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Safari
 */
public class Answer {
    String clickedNodeID;
    Question question;
    
    public Answer() {
    }

    public Answer(String clickedNodeID, Question question) {
        this.clickedNodeID = clickedNodeID;
        this.question = question;
    }

  
    
    
    public boolean checkAnswer(String answerNodeID,Question thisQuestion){
        return answerNodeID.equals(thisQuestion.getRandomCountryID());
    }
}
