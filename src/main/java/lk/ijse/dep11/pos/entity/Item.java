package lk.ijse.dep11.pos.entity;

import lk.ijse.dep11.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandomParameters;
import java.util.Set;

@Entity
@Table(name = "item")
@Data // @ToString, @Getter, @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    @Id
    @Column(name = "item_id", length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 200, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 50, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", length = 50, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 50, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 50, nullable = false)
    private double sellingPrice;

    @Column(name = "active_status", columnDefinition = "TINYINT default 0")
    private boolean activeStatus;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetails> orderDetailsSet;
}


