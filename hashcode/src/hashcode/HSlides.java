package hashcode;

import java.util.Set;

public class HSlides extends Slides {

    private final HPhoto photo;

    public HSlides(HPhoto photo) {
        this.photo = photo;
    }

    @Override
    public Set<String> getTags() {
        return photo.getTags();
    }
}
