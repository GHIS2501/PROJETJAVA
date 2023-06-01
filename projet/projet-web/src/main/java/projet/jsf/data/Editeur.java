package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Editeur implements Serializable{

	// Champs
	
		private Integer			IdEditeur;
		
		@NotBlank( message = "Le nom doit être renseigné")
		@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
		private String			nom;

		@NotBlank( message = "Le prénom doit être renseigné")
		@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
		private String			prenom;

		private List<Document>	documents = new ArrayList<>();
	
	
		
		
		
		
	
	
}
