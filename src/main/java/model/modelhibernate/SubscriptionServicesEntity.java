package model.modelhibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription_services", schema = "exam", catalog = "")
public class SubscriptionServicesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "subscription_id", nullable = false)
    private int subscriptionId;
    @Basic
    @Column(name = "service_id", nullable = false)
    private int serviceId;


    public SubscriptionServicesEntity(int subscriptionId, int serviceId) {
        this.subscriptionId = subscriptionId;
        this.serviceId = serviceId;
    }
}
