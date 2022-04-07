package fis.training.filnal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
    private Long customerId;

    @Column(name = "Customer_Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Birthday", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "IdentityNo", nullable = false, unique = true, length = 12)
    private String identityNo;

    @Column(name = "Mobile", nullable = true, length = 10)
    private String mobile;

    @Column(name = "CustomerType", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @Column(name = "CreateDatetime", nullable = false)
    private LocalDateTime createDatetime;

    @Column(name = "UpdateDatetime", nullable = false)
    private LocalDateTime updateDatetime;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;
}
