package model.modelmongo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientMongo {
    private String name;
    private int balance;
}
