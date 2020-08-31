package guru.springframework.sfgpetclinic.model;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
	private Set<Pet> pets = new HashSet<>();

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "telephone")
	private String telephone;
	
	@Builder
	public Owner(Set<Pet> pets, String address, String city, String telephone,String firstName , String lastName, Long id) {
		super(firstName,lastName,id);
		this.pets = pets;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}
	
	
}
