package model.modelhibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "subscriptions", schema = "exam")
public class SubscriptionsEntity {
    public SubscriptionsEntity(int clientId, Date startDate, Date endDate, int paid) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "client_id", nullable = false)
    private int clientId;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "paid", nullable = false)
    private int paid;





}
