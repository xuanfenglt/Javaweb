package serviceImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.Students;
import service.StudentsDAO;

/*
 * ѧ��ҵ���߼��ӿ�ʵ����
 * */
public class StudentsDAO_Impl implements StudentsDAO {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Override
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		
		List<Students> list = null;
		String hql = "";
		
		try{
			//�������ö���
			Configuration config = new Configuration().configure();
			//��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//�����Ự��������
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			//�Ự����
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			
			/*
			 * ���ݿ��б�����students��ע�����ﲻ����д��from students
			 * ��ΪHQL����б�����ORMӳ�������*/
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		finally{
			transaction.commit(); //�ύ����
			session.close(); //�رջỰ�������ͷſ��ܵ������ݿ����ӳ����
			sessionFactory.close(); //�رջỰ����	
		}
	}

	@Override
	public Students queryStudentBysid(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		return false;
	}

}