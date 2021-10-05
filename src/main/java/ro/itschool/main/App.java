package ro.itschool.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.itschool.entity.Address;
import ro.itschool.entity.User;
import ro.itschool.hibernate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Address address = new Address();
		address.setCity("city");
		address.setNr("123");
		address.setStreet("street");

		User user = new User();
		user.setLastName("last name");
		user.setFirstName("first name");
		user.setCnp(1880505000001L);
		user.setAddress(address);
		address.setUser(user);

		Address address2 = new Address();
		address2.setCity("city2");
		address2.setNr("123");
		address2.setStreet("street2");

		session.save(address2);

		session.save(user);

		transaction.commit();
		session.close();

		// bidirectionalitate
		session = HibernateUtil.getSessionFactory().openSession();
		User user2 = session.find(User.class, 2L);
		System.out.println(user2.getAddress());

		Address address3 = session.find(Address.class, 2L);
		System.out.println(address3.getUser());
		session.close();
	}

}
