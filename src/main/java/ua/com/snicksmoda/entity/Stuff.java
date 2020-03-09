package ua.com.snicksmoda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stuff {

    @Id
    @GeneratedValue
    private Long idStuff;

    private String name;
    private String description;
    private Long price;
    private String urlPhoto;

    @ManyToOne(cascade = CascadeType.ALL)
    private Orders orders;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private Basket basket;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "stuff")
    List<StuffReview> stuffReviewList;

    public Stuff() {
    }

    public Stuff(String name, Category category, String description, Long price, String urlPhoto) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.urlPhoto = urlPhoto;
    }

    public Long getIdStuff() {
        return idStuff;
    }

    public void setIdStuff(Long idStuff) {
        this.idStuff = idStuff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<StuffReview> getStuffReviewList() {
        return stuffReviewList;
    }

    public void setStuffReviewList(List<StuffReview> stuffReviewList) {
        this.stuffReviewList = stuffReviewList;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "idStuff=" + idStuff +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", orders=" + orders +
                ", category=" + category +
                ", basket=" + basket +
                '}';
    }

    public void add(Stuff stuff) {

    }
}
