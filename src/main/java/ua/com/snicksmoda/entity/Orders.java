package ua.com.snicksmoda.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue
    private Long idOrders;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orders")
    List<Stuff> stuffList;

    public Orders() {
    }

    public Orders(Client client, List<Stuff> stuffList) {
        this.client = client;
        this.stuffList = stuffList;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Stuff> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff> stuffList) {
        this.stuffList = stuffList;
    }
}
