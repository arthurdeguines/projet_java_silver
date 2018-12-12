package entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class ClientEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private List<CommandeEntity> commandes;
	
	public List<CommandeEntity> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeEntity> commandes) {
		this.commandes = commandes;
	}

	public ClientEntity() {
		
	}
	
	public ClientEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
    	return this.lastname;
    }
    
    public void setLastname(String lastname) {
    	this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstname + " " + lastname + "\'" +
                '}';
    }
	
}
