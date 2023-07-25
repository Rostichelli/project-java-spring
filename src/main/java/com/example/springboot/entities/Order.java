package com.example.springboot.entities;

import com.example.springboot.entities.enums.StatusOrder;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final Integer serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;
    private int statusOrder;
    @ManyToOne
    @JoinColumn(name = "fk_client")
    private User client;

    public Order() {
    }

    public Order(Integer id, Instant moment, StatusOrder statusOrder, User client) {
        this.id = id;
        this.moment = moment;
        setStatusOrder(statusOrder);
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public StatusOrder getStatusOrder(int code) {
        return StatusOrder.valueOf(code);
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", client=" + client +
                '}';
    }
}
