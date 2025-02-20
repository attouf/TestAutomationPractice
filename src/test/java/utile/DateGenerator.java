package utile;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {


    public static String generateDateHeure(){
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }

}
