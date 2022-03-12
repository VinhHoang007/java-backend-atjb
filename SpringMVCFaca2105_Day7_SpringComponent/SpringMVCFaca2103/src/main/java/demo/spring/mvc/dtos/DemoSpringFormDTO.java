package demo.spring.mvc.dtos;

import java.util.Arrays;

// Lombok
// @Getter
// @Setter
public class DemoSpringFormDTO {

    private int id;
    private String name;
    private boolean receiveNewsletter;
    private String[] interests;
    private String favouriteWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReceiveNewsletter() {
        return receiveNewsletter;
    }

    public void setReceiveNewsletter(boolean receiveNewsletter) {
        this.receiveNewsletter = receiveNewsletter;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String getFavouriteWord() {
        return favouriteWord;
    }

    public void setFavouriteWord(String favouriteWord) {
        this.favouriteWord = favouriteWord;
    }

    @Override
    public String toString() {
        return "DemoSpringFormDTO [id=" + id + ", name=" + name + ", receiveNewsletter=" + receiveNewsletter
                + ", interests=" + Arrays.toString(interests) + ", favouriteWord=" + favouriteWord + "]";
    }

}
