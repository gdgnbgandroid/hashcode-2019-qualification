package hashcode;

import java.util.HashSet;
import java.util.Set;

public class VSlides extends Slides {

    private final VPhoto photo1;
    private final VPhoto photo2;

    public VSlides(VPhoto photo1, VPhoto photo2) {
        this.photo1 = photo1;
        this.photo2 = photo2;
    }

    @Override
    public Set<String> getTags() {
        Set<String> res = new HashSet<>();
        res.addAll(photo1.getTags());
        res.addAll(photo2.getTags());
        return res;
    }

    @Override
    public String toString() {
        return photo1.getId() + " " + photo2.getId();
    }
}
