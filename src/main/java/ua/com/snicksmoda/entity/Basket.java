package ua.com.snicksmoda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue
    private Long idBasket;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "basket")
    List<Stuff> stuffList;

    public Basket() {
    }

    public Basket(List<Stuff> stuffList) {
        this.stuffList = stuffList;
    }

    public Long getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Long idBasket) {
        this.idBasket = idBasket;
    }

    public List<Stuff> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff> stuffList) {
        this.stuffList = stuffList;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", stuffList=" + stuffList +
                '}';
    }
}
