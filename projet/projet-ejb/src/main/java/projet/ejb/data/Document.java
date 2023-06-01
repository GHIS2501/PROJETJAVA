package projet.ejb.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table( name = "document" )
public class Document  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idDocument")
	private int			idDocument;
	
	@Column( name = "nomDoc")
	private String		nomDoc;
	
	@Column( name = "motdepasse")
	private String		motDePasse;
	
	@Column( name = "email")
	private String		email;
	
	@ElementCollection( fetch = EAGER )
	@CollectionTable( name = "role", joinColumns = @JoinColumn( name = "idcompte" ) )
	@Column( name = "role")
	private List<String> roles = new ArrayList<>();	
	
	
	// Constructeurs
	
	public Document() {
	}

	public Document(int id, String nomDoc, String motDePasse, String email) {
		this.idDocument = id;
		this.nomDoc = nomDoc;
		this.motDePasse = motDePasse;
		this.email = email;
	}
	
		
	// Getters & setters
	
	public int getId() {
		return idDocument;
	}
	
	public void setidDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public String getnomDoc() {
		return nomDoc;
	}

	public void setnomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

    
	// equals() et hashcode()

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDocument;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (idDocument != other.idDocument)
			return false;
		return true;
	}
	
}
