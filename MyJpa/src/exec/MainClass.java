package exec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pojo.Evento;
import pojo.EventoPub;
import pojo.Gioco;
import pojo.GiocoAd;
import pojo.GiocoNAd;
import pojo.Pc;
import pojo.Regola;
import pojo.Smartphone;
import pojo.Tablet;

public class MainClass {

	private static void getMaNPcaG() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Pc t = new Tablet(100, "t1", "i5", null, 10, true),
		   s = new Smartphone(110, "s1", "i7", null, "android");
		em.persist(t);
		em.persist(s);
		
		Set<Pc> pcs = new HashSet<>();
		pcs.add(t);
		pcs.add(s);
		
		Gioco g1 = new GiocoAd(100, "g1", pcs, 10, true),
			  g2 = new GiocoNAd(110, "g2", pcs, 20, 'm');
		
		em.persist(g1);
		em.persist(g2);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void gen1a1PcaG() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Gioco g = new GiocoAd(10, "mio g", 20, true);
//		Pc t1 = new Tablet(10, "t1", "i5", g, 20, true),
//		   s1 = new Smartphone(11, "s1", "i7", g, "android");
//		
//		em.persist(g);
//		em.persist(t1);
//		em.persist(s1);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void gen1aNPcaG() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Gioco 	g1 = new GiocoAd(1, "g1", 10, true),
//				g2 = new GiocoAd(2, "g2", 25, false),
//				g3 = new GiocoAd(3, "g3", 30, true);
//		List<Gioco> giochi = new ArrayList<>();
//		giochi.add(g1);
//		giochi.add(g2);
//		giochi.add(g3);
		
//		Evento e = new EventoPub(10, "e1", 1, giochi, 10);
//		
//		for (Gioco g : giochi)
//			em.persist(g);
//		
//		em.persist(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void getGiocoFromPcId(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		
//		Pc p = em.find(Smartphone.class, id);
//		Gioco g = p.getGioco();
//		
//		System.out.println(p + "\n" + g);
		
		em.close();
		emf.close();
	}
	
	private static void genNa1PcaG() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Gioco g = new GiocoAd(1, "mio g", 20, true);
//		Pc t1 = new Tablet(1, "t1", "i5", g, 20, true),
//		   s1 = new Smartphone(2, "s1", "i7", g, "android");
//		
//		em.persist(g);
//		em.persist(t1);
//		em.persist(s1);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	private static void genPc() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Tablet  t1 = new Tablet(1, "mio tb1", "i5", 10, true),
//				t2 = new Tablet(2, "mio tb2", "i3", 25, false),
//				t3 = new Tablet(3, "mio tb3", "i7", 30, true);
//		Smartphone 	s1 = new Smartphone(1, "mio sp1", "arm", "android"),
//					s2 = new Smartphone(2, "mio sp2", "arm", "android"),
//					s3 = new Smartphone(3, "tuo sp3", "arm", "ios");
				
//		em.persist(t1);
//		em.persist(t2);
//		em.persist(t3);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void genGiochi() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		GiocoAd gad1 = new GiocoAd(1, "giostra1", 5, false),
//				gad2 = new GiocoAd(2, "giostra2", 7, false),
//				gad3 = new GiocoAd(3, "giostra3", 8, true);
//		GiocoNAd gnad1 = new GiocoNAd(4, "panca1", 20, 'm'),
//				 gnad2 = new GiocoNAd(5, "panca2", 25, 'f'),
//				 gnad3 = new GiocoNAd(6, "panca3", 22, 'f');
//		
//		em.persist(gad1);
//		em.persist(gad2);
//		em.persist(gad3);
//		em.persist(gnad1);
//		em.persist(gnad2);
//		em.persist(gnad3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	private static void genEventi() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		EventoPub ep1 = new EventoPub(1, "Ev pub1", 1, 100),
//				  ep2 = new EventoPub(2, "Ev pub2", 2, 500),
//				  ep3 = new EventoPub(3, "Ev pub3", 3, 1000);
//		EventoPriv epr1 = new EventoPriv(4, "Ev priv1", 1, 1),
//				   epr2 = new EventoPriv(5, "Ev priv2", 2, 2),
//				   epr3 = new EventoPriv(6, "Ev priv3", 3, 1);
//		
//		em.persist(ep1);
//		em.persist(ep2);
//		em.persist(ep3);
//		em.persist(epr1);
//		em.persist(epr2);
//		em.persist(epr3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	private static void namedQuery() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
				
		Query q = em.createNamedQuery("getRuleFromId");
		q.setParameter("id", 7);
		
		List<Regola> regole = q.getResultList();
		System.out.println("Regola 7:");
		for (Regola r : regole)
			System.out.println(r);
		
		em.close();
		emf.close();
	}
	private static void jpqlQuery() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
				
		Query q = em.createQuery(" SELECT reg.nome FROM Regola reg ");
		
		List<String> nomi = q.getResultList();
		
		System.out.println("Nomi regole");
		for (String nome : nomi)
			System.out.println(nome);
		
		em.close();
		emf.close();
	}
	private static void elimRegola() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Regola r = em.find(Regola.class, 8);
		em.remove(r);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	private static void updateRegola() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Regola r = em.find(Regola.class, 7);
		System.out.println(r);
		
		r.setNome("new jpa name");
		em.getTransaction().commit();
		
		System.out.println(r);
		
		em.close();
		emf.close();
	}
	private static void creaRegola() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		Regola r = new Regola(8, "jpa rule", "desc jpa rule", "All");
		em.persist(r);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		
		getMaNPcaG();
	}

}
