package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Document implements Serializable {


	private Integer			idDocument;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			NomDoc;

	private Boolean disponible;
	
	@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;

//	@NotNull( message = "L'auteur est obligatoire")
//	private Auteur		auteur;
	
	@NotNull( message = "Le compte est obligatoire")
	private Compte		compte;
	
//	@NotNull( message = "L'éditeur est obligatoire")
//	private Editeur		editeur;

	public Document () {
	}
	public Document(Integer idDocument,String nomDoc,Boolean disponible,  Categorie categorie, Auteur auteur,Compte compte, Editeur editeur) {
		this.idDocument = idDocument;
		NomDoc = nomDoc;
		this.disponible = disponible;
		this.categorie = categorie;
//		this.auteur = auteur;
		this.compte = compte;
//		this.editeur = editeur;
	}


	
	
}
