import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validateIP {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String IP_REGEX = "[\\d]{3}-[\\d]{3}-[\\d]{3}-[\\d]{3}";
    public validateIP(){
        pattern = Pattern.compile(IP_REGEX);
    }
    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
