package responseDto;

import lombok.Data;

@Data
public class Dog {
    private Weight weight;
    private Height height;
    private int id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private String origin;
    private String reference_image_id;

    @Data
    public static class Weight {
        private String imperial;
        private String metric;
    }

    @Data
    public static class Height {
        private String imperial;
        private String metric;
    }
}