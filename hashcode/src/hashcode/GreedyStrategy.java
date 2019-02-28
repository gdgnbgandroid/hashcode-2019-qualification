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

        List<Slides> vPhotos = createVSlides(photoList.stream()
                .filter(p -> p instanceof VPhoto)
                .map(p -> (VPhoto) p)
                .collect(Collectors.toList()));


        Collections.sort(hPhotos, (o1, o2) -> o2.getTags().size() - o1.getTags().size());
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

    private List<Slides> createVSlides(List<VPhoto> photos) {
        List<Slides> vSlides = new ArrayList<>();
        final int size = photos.size();
        Set<VPhoto> taken = new HashSet<>();

        while(taken.size() < size) {
            VPhoto workingVp = null;
            int i = 0;
            for(i = 0; i < size; i++) {
                if(!taken.contains(photos.get(i))) {
                    workingVp = photos.get(i);
                    taken.add(workingVp);
                    break;
                }

            }


            long bestScore = -1;
            int bestIdx = 0;
            for(; i < size; i++) {
                VPhoto vp = photos.get(i);


            }
        }

        return vSlides;
    }
}
