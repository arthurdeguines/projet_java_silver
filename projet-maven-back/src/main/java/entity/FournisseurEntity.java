package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "fournisseur")
public class FournisseurEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "fournisseur_fruit",
		joinColumns = { @JoinColumn(name = "fournisseur_id")},
		inverseJoinColumns = { @JoinColumn(name = "fruit_id")}
	)
	private Set<FruitEntity> fruits = new HashSet<>();
	
	@Column(name = "company_name")
	private String companyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<FruitEntity> getFruits() {
		return fruits;
	}

	public void setFruits(Set<FruitEntity> fruits) {
		this.fruits = fruits;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
