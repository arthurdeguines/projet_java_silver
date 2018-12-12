package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "fruit")
public class FruitEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "fruits")
	private Set<FournisseurEntity> fournisseurs = new HashSet<>();
	
	@ManyToMany(mappedBy = "fruits")
	private Set<CommandeEntity> commandes = new HashSet<>();
	
	//Ajouter un prix en fonction prix fournisseurs
	
	public Set<CommandeEntity> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<CommandeEntity> commandes) {
		this.commandes = commandes;
	}

	@Column(name = "stock")
	private Long stock;
	
	public FruitEntity() {
		
	}
	
	public FruitEntity(Long stock) {
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<FournisseurEntity> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<FournisseurEntity> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
}
