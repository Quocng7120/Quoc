package fis.training.filnal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
    private LocalDateTime dateTime;
    private CustomerType customerType;
    private Integer status;
    private Double total;
    private Long count;
}
