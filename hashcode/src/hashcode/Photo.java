package hashcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Photo implements Tagable {

    private final int id;


    private Set<String> tags;

    public Photo(Set<String> tags, int id) {
        this.tags = tags;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Photo newInstance(String s, int id) {
        String pattern = "([HV])\\s+?(\\d+)((\\s+?\\w+?)+)";
        if (!s.matches(pattern)) return null;

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);

        if (matcher.matches()) {
            String orientation = matcher.group(1);
            String tags = matcher.group(3).trim();

            Set<String> tagSet = new HashSet<>(Arrays.asList(tags.split(" ")));

            if (orientation.equals("H")) {
                return new HPhoto(tagSet, id);
            } else if (orientation.equals("V")) {
                return new VPhoto(tagSet, id);
            }

        }
        return null;
    }

    @Override
    public Set<String> getTags() {
        return tags;
    }
}
