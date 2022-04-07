package fis.training.final_test_mrphuoc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String login;

	@Column
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity roleEntity;
}
