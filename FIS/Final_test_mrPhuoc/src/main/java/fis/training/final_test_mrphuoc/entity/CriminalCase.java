package fis.training.final_test_mrphuoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "CriminalCase")
@NoArgsConstructor
@AllArgsConstructor
public class CriminalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "criminalCaseId",referencedColumnName="id")
    private Set<Working_Detective_Case> workingSet;

    private String number;
    private CaseType type;
    private CaseStatus status;
    private String shortDescription;
    private String detailedDescription;
    private String notes;
}
