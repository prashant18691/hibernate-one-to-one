package com.prs.hibernateonetoone.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="TRANSACTION")
public class Transaction implements Serializable{
    private int id;
    private Date date;
    private float total;
    private Customer customer;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }

    public Transaction(){

    }

    @Id
    @Column(name = "TXN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "TXN_DATE")
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "TXN_TOTAL")
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    @OneToOne(mappedBy = "txn",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
