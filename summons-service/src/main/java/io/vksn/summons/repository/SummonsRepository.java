package io.vksn.summons.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.vksn.summons.entity.Event;
import io.vksn.summons.entity.Invitation;
import io.vksn.summons.entity.Table;
import io.vksn.summons.qualifier.Repository;

@Repository
@Dependent
@Transactional
public class SummonsRepository {

	private static Logger log = Logger.getLogger(SummonsRepository.class.getName());
	
	@PersistenceContext(unitName="summonsPU")
	private EntityManager entityManager;

	public Invitation getInvitation() {
		Query query = entityManager.createNamedQuery("", Invitation.class);

		return (Invitation) query.getSingleResult();
	}

	public Event store(Event event) {
		log.severe("persisting event" + event.getName());
		entityManager.persist(event);
		entityManager.flush();
		entityManager.refresh(event);
		return event;
	}
	
	public Invitation update(Invitation invitation) {
		entityManager.merge(invitation);
		entityManager.flush();
		entityManager.refresh(invitation);
		return invitation;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Event event) {
		entityManager.merge(event);
	}

	public Event findEvent(long id) {
		Query query = entityManager.createNamedQuery(Event.FIND_BY_ID, Event.class);
		query.setParameter("id", id);
		return (Event) query.getSingleResult();
	}

	public Event findEvent(String identifier) {
		Query query = entityManager.createNamedQuery(Event.FIND_BY_SIGN, Event.class);
		query.setParameter("sign", identifier);
		return (Event) query.getSingleResult();
	}
	
	public Event saveSeatingPlan(String identifier, List<Table> seatingPlan) {
		Event event = findEvent(identifier);
		event.setSeatingPlan(seatingPlan);
		for(Table table : seatingPlan) {
			entityManager.persist(table);
		}
		entityManager.merge(event);
		return event;
	}

	@SuppressWarnings("unchecked")
	public List<Table> loadEventSeatingPlane(String eventIdentifier) {
		//SECURITY_WEAKNESS: weakness_1: JPQL query injection 
		String queryStr = "SELECT e.seatingPlan FROM Event e WHERE  e.sign = '" + eventIdentifier + "'";
		Query query = entityManager.createQuery(queryStr);
		return query.getResultList();
	}
}
