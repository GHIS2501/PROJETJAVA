package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoDocument;
import projet.ejb.data.Document;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoDocument  implements IDaoDocument  { 

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Document doc) {
		em.persist(doc);
		em.flush();
		return doc.getId();
	}

	@Override
	public void modifier(Document compte) {
		em.merge( compte );
	}

	@Override
	public void supprimer(int idDocument) {
		em.remove( retrouver(idDocument) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Document retrouver(int idDocument) {
		return em.find( Document.class, idDocument );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Document> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Compte c ORDER BY c.pseudo";
		var query = em.createQuery( jpql, Document.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Document validerAuthentification( String pseudo, String motDePasse )  {
	    var jpql = "SELECT c FROM Compte c WHERE c.pseudo=:pseudo AND c.motDePasse = :motDePasse ";
	    var query = em.createQuery( jpql, Document.class );
	    query.setParameter( "pseudo", pseudo );
	    query.setParameter( "motDePasse", motDePasse );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitePseudo( String pseudo, int idCompte )  {
	    var jpql = "SELECT COUNT(c) FROM Compte c WHERE c.pseudo=:pseudo AND c.id <> :idCompte ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "pseudo", pseudo );
	    query.setParameter( "idCompte", idCompte );
        return query.getSingleResult() == 0;
	}
	
}
