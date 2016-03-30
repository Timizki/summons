package io.vksn.summons.repository;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import io.vksn.summons.entity.Event;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
// SECURITY_WEAKNESS: weakness_8: Hard coding datasource's username and password
 @DataSourceDefinition(className = "javax.sql.XADataSource", name =
 "jdbc/notInse", user = "sa", password = "password", url =
 "jdbc:h2:~/summons10.db;AUTO_SERVER=TRUE")
//SECURITY_WEAKNESS: weakness-15: EJB bean is not serializable 
public class ListEventsRepository {

	@PersistenceContext(unitName = "summonsPU")
	private EntityManager entityManager;
	
	@Resource
	private EJBContext context;

	@Resource
	private UserTransaction userTransaction;

	@SuppressWarnings("unchecked")
	public List<Event> listEvents() {
		try {
			context.getUserTransaction().begin();
			Query query = entityManager.createNamedQuery(Event.FIND_ALL, Event.class);
			List<Event> events = query.getResultList();
			context.getUserTransaction().commit();
			return events;
		} catch (Exception e) {			
			// SECURITY_WEAKNESS: weakness_9: Bean managed transaction is not rollbacked. 
			throw new RuntimeException();
		}
	}
}
