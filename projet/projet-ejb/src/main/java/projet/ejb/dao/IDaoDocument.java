package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Document;


public interface IDaoDocument {

	int			inserer( Document compte );

	void 		modifier( Document compte );

	void 		supprimer( int idCompte );

	Document 		retrouver( int idCompte );

	List<Document> listerTout();

	Document 		validerAuthentification( String pseudo, String motDePasse );

	boolean 	verifierUnicitePseudo( String pseudo, int idCompte );

}
