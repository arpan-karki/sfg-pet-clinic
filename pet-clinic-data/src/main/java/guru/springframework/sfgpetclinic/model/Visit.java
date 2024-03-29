package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import guru.springframework.sfgpetclinic.model.Owner.OwnerBuilder;
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
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "pet_id")
	private Pet pet;

}
