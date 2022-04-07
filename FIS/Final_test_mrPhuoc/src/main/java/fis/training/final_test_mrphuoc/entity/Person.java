package fis.training.final_test_mrphuoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    private String username;
    private String firstName;
    private String lastName;
    private String password;
}
