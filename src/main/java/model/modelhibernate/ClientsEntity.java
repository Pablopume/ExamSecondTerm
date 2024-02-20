package model.modelhibernate;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
@Data
@Entity
@Table(name = "clients", schema = "exam", catalog = "")
public class ClientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "membership_type", nullable = false, length = 100)
    private String membershipType;
    @Basic
    @Column(name = "balance", nullable = false, precision = 0)
    private double balance;






}
