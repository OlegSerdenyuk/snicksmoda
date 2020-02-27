package ua.com.snicksmoda.entity;

import javax.persistence.*;

@Entity
public class StuffReview {

    @Id
    @GeneratedValue
    private Long idStuffReview;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stuff stuff;

    public StuffReview() {
    }

    public StuffReview(String text, Stuff stuff) {
        this.text = text;
        this.stuff = stuff;
    }

    public Long getIdStuffReview() {
        return idStuffReview;
    }

    public void setIdStuffReview(Long idStuffReview) {
        this.idStuffReview = idStuffReview;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    @Override
    public String toString() {
        return "StuffReview{" +
                "idStuffReview=" + idStuffReview +
                ", text='" + text + '\'' +
                ", stuff=" + stuff +
                '}';
    }
}
