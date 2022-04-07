package fis.training.final_test_mrphuoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Evidence")
@NoArgsConstructor
@AllArgsConstructor
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "storageId", referencedColumnName = "id")
    private Storage storage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "criminalCaseId", referencedColumnName = "id")
    private CriminalCase criminalCase;

    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
}
