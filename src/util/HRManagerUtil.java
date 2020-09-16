package util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class HRManagerUtil {

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    //Thanks to Lunf (https://stackoverflow.com/questions/6584484/how-to-generate-a-unique-identifier-of-a-fixed-length-in-java)
    public static String generateId() {
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        UUID idThree = UUID.randomUUID();
        UUID idFour = UUID.randomUUID();

        String time = idOne.toString().replace("-", "");
        String time2 = idTwo.toString().replace("-", "");
        String time3 = idThree.toString().replace("-", "");
        String time4 = idFour.toString().replace("-", "");

        StringBuilder data = new StringBuilder();
        data.append(time);
        data.append(time2);
        data.append(time3);
        data.append(time4);

        SecureRandom random = new SecureRandom();
        int beginIndex = random.nextInt(100);       //Begin index + length of your string < data length
        int endIndex = beginIndex + 8;            //Length of string which you want

        return data.substring(beginIndex, endIndex);
    }
}
