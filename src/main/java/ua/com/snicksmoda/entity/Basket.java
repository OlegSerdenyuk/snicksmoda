package ua.com.snicksmoda.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue
    private Long idBasket;

    @OneToOne(mappedBy = "basket")
    private Client client;

    @ManyToOne
    private Stuff stuff;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "basket")
    List<Stuff> stuffList = new ArrayList<>();

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStuff(Stuff stuff) {
        this.stuff.add(stuff);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", stuffList=" + stuffList +
                '}';
    }
}
