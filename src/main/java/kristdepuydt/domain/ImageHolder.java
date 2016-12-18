package kristdepuydt.domain;

import java.util.List;

public class ImageHolder {

    private String url;
    private String description;
    private List<String> otherBeelden;

    public ImageHolder(String url, String description, List<String> otherBeelden) {
        this.url = url;
        this.description = description;
        this.otherBeelden = otherBeelden;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOtherBeelden() {
        return otherBeelden;
    }

    public void setOtherBeelden(List<String> otherBeelden) {
        this.otherBeelden = otherBeelden;
    }
}
