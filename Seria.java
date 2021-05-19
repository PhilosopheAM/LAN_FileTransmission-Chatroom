package FileTransmission;

import java.io.*;

public class Seria {
    public void seriaTest()throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("Output.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
    }
}
