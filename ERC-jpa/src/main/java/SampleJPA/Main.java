package SampleJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.soap.Text;

import SampleJPA.entity.Member;
import SampleJPA.entity.Student;
import SampleJPA.entity.Team;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

//		
//		Student student = new Student();
//		student.setName("A");
//		student.setGrade(1);
//		
		Member member = new Member();
		member.setUsername("�̴�ȣ");
		em.persist(member);
		Member member2 = new Member();
		member.setUsername("�վƼ�");
		em.persist(member2);

		Team team = new Team();
		team.setName("��ȭ");
		member.setTeam(team);
		em.persist(team);
		
		Team findTeam = em.find(Team.class, 4L );
		List<Member> list = findTeam.getMembers();
		for(Member m : list) {
			System.out.println(m.getUsername());
		}
		
//
//		Member findMember =em.find(Member.class,2l);
//		System.out.println(findMember.getUsername());
//		System.out.println(findMember.getTeam().getName());

		tx.commit();
		em.close();
		emf.close();
	}
}
