package com.abc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.domain.CustomerDetails;
import com.abc.repository.UserRepository;

@Repository
// @EnableTransactionManagement
public class H2HApplicationDao {

	@Autowired
	private UserRepository userRepository;

	 @PersistenceContext
	 private EntityManager entityManager;

	@Transactional
	public CustomerDetails saveApplicationDetails(CustomerDetails customerDetails) {
		CustomerDetails custDetailsModel = new CustomerDetails();
		boolean isSaved = false;
		try {
			custDetailsModel = userRepository.save(customerDetails);
			isSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isSaved) {
			// getCustDetails = userRepository.findOne(1);
		}
		return custDetailsModel;
	}

	public CustomerDetails getCustomerInformation(String cif) {
		CustomerDetails custDetails = null;
		try {
			System.out.println(cif);
			custDetails = userRepository.findByCifNumber(cif);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return custDetails;
	}

	public CustomerDetails getApplicationDetails(Integer applicationId) {
		CustomerDetails custDetails = new CustomerDetails();
		try {
			if (null != applicationId) {
				StringBuilder sbHQLSelect = new StringBuilder();
				sbHQLSelect.append(" select cust.* from customer cust inner join application_details app ");
				sbHQLSelect.append(" on cust.customer_id = app.customer_id ");
				sbHQLSelect.append(" inner join customer_contact cont ");
				sbHQLSelect.append(" on app.application_id = cont.application_id ");
				sbHQLSelect.append(" where app.application_Id = :applicationId ");
				// Query query = entityManager.createQuery(sbHQLSelect.toString() );
				Query query = entityManager.createNativeQuery(sbHQLSelect.toString(),CustomerDetails.class);

				query.setParameter("applicationId", applicationId);
				custDetails = (CustomerDetails) query.getSingleResult();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return custDetails;

	}
}
