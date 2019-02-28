package hashcode;

import java.util.*;
import java.util.stream.Collectors;

public class GreedyStrategy {

    private List<Photo> photoList = null;

    private SlidesShow slidesShow = null;

    public GreedyStrategy(List<Photo> photoList) {
        this.photoList = photoList;
        slidesShow = new SlidesShow();
    }

    public SlidesShow solve() {

        List<Slides> hPhotos = photoList.stream()
                .filter(p -> p instanceof HPhoto)
                .map(photo -> new HSlides((HPhoto) photo))
                .collect(Collectors.toList());

        System.out.println("Size of H Photos: " + hPhotos.size());

        //List<Photo> vPhotos = photoList.stream().filter(p -> p instanceof VPhoto).collect(Collectors.toList());

        Collections.sort(hPhotos, Comparator.comparingInt(o -> o.getTags().size()));
        //Collections.sort(vPhotos, Comparator.comparingInt(o -> o.getTags().size()));

        slidesShow.addSlides(hPhotos.get(0));
        final int size = hPhotos.size();
        Set<Slides> taken = new HashSet<>();
        taken.add(hPhotos.get(0));

        while(taken.size() < size) {
            System.out.println(taken.size() + " H photos haven been taken.");
            long bestScore = -1;
            int bestIdx = 0;
            for(int j = 1; j < hPhotos.size(); j++) {
                if(!taken.contains(hPhotos.get(j))) {
                    long score = slidesShow.testScore(hPhotos.get(j));
                    if (score > bestScore) {
                        bestScore = score;
                        bestIdx = j;
                    }
                }
            }
            slidesShow.addSlides(hPhotos.get(bestIdx));
            taken.add(hPhotos.get(bestIdx));

        }

        return slidesShow;
    }
}
