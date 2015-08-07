package devexchanges.info.navigationdrawer;

/**
 * Created by Hong Thai.
 */
public class SocialNetwork {
    private int imageId;
    private int bigImageId;
    private String name;
    private String country;

    public SocialNetwork(int imageId, int bigImageId, String name, String country) {
        this.country = country;
        this.bigImageId = bigImageId;
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getBigImageId() {
        return bigImageId;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }
}
