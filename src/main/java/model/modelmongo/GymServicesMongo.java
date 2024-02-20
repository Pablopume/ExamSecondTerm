package model.modelmongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
public class GymServicesMongo {
    private int _id;
    private String name;
    private int price;
}
