package fis.training.order.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "productId",referencedColumnName="productId")
    private Product product;

    @Column(name = "amount")
    private Integer amount;
}
