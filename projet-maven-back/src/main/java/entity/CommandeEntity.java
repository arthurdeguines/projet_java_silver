package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "commande")
public class CommandeEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "ref_commande")
	private String refCommande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private ClientEntity client;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
		name = "commande_fruit",
		joinColumns = {@JoinColumn(name = "commande_id")},
		inverseJoinColumns = {@JoinColumn(name = "fruit_id")}
	)
	private Set<FruitEntity> fruits = new HashSet<>();

	public Set<FruitEntity> getFruits() {
		return fruits;
	}

	public void setFruits(Set<FruitEntity> fruits) {
		this.fruits = fruits;
	}

	public CommandeEntity() {
		
	}
	
	public CommandeEntity(ClientEntity client, String refCommande) {
		this.client = client;
		this.refCommande = refCommande;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefCommande() {
		return refCommande;
	}

	public void setRefCommande(String refCommande) {
		this.refCommande = refCommande;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "- " + id + " : " +
				"Commande n°" + refCommande +
				"(client : " + client + ")";
	}
}
