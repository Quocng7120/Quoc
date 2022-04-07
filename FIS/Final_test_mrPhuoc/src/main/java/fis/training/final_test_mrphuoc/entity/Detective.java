package fis.training.final_test_mrphuoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Detective")
@NoArgsConstructor
@AllArgsConstructor
public class Detective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId",referencedColumnName = "id")
    private Person person;

    private String badgeNumber;
    private Ranks rankz;
    private Boolean armed;
    private EmploymentStatus status;
}
