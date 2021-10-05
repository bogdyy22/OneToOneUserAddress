package ro.itschool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "user")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	private String city;

	private String street;

	private String nr;

	@OneToOne(mappedBy = "address")
	@PrimaryKeyJoinColumn
	private User user;
}
