// I miss U

// I still remember the day we met, 

// the girl in red shirt, saying hello with a bright smile.

// Applique in her shirt, blooming flowers in her eyes.

// I promise, it will be the unfogettable day in my whole life, in which we met 
// and I falled in love and drown to dream.
package FileTransmission;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class test implements Serializable{
    StringBuilder missU = new StringBuilder();
    String a = "I miss U\n";
    String b = " I still remember the day we met,\n";
    String c = "the girl with red hair band, saying hello with a bright smile.\n";
    String d = "Applique in her shirt, blooming flowers in her dimples, and eyes twinkled like stars.\n";
    String e = "I promise, it will be the unfogettable day in my whole life, in which we met\n";
    String f = "and I falled in love and drown to dream.";
    String[] all = {a,b,c,d,e,f};

    public test(){
        for(String good:all){
            missU.append(good);
        }
        String ImissU = missU.toString();
    }
}