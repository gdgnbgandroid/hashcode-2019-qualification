package hashcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SlidesShow {

    private final List<Slides> slides;

    private long score;

    public SlidesShow() {
        score = 0L;
        this.slides = new LinkedList<>();
    }

    public void addSlides(Slides s) {
        slides.add(s);
    }

    private long calculateScore(Slides s1, Slides s2) {
        Set<String> set1 = new HashSet<>(s1.getTags());
        Set<String> set2 = s2.getTags();
        set1.retainAll(set2);
        int commonTagsNum = set1.size();
        int tagsOnlyInS1 = s1.getTags().size() - commonTagsNum;
        int tagsOnlyInS2 = s2.getTags().size() - commonTagsNum;

        return Math.min(commonTagsNum, Math.min(tagsOnlyInS1, tagsOnlyInS2));

    }

    public long testScore(Slides s) {
        return slides.isEmpty() ? s.getTags().size() : calculateScore(s, slides.get(slides.size() - 1));
    }


    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(slides.size()).append("\n");
        slides.forEach(s -> strBuilder.append(s).append("\n"));
        return strBuilder.toString();
    }
}
