package com.ey.hib;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Hibtest {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query<Student> q=session.createQuery("from Student",Student.class);
		List<Student> slist=q.list();
		
		for(Student st:slist) {
			System.out.println(st.getRoll_no()+"\t"+st.getStudent_name()+"\t"+st.getBranch());
		}
	}

}
