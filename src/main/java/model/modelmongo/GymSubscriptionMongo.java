package model.modelmongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class GymSubscriptionMongo {
    private ObjectId _id;
    private LocalDate startDate;
    private LocalDate endDate;
    private ClientMongo clientMongo;
    private GymServicesMongo gymServicesMongo;
}
