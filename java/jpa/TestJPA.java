/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjpa;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author elton.ballhysa
 */
public class TestJPA {

    private EntityManagerFactory emf;
    private EntityManager em;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestJPA t = new TestJPA();
        //t.testMisc();
        List<Film> rFilms = t.testSelect("R");
        System.out.printf("%d films with R rating\n", rFilms.size());
        t.testUpdate(rFilms);
        Actor actor = t.testNewActor("Al", "Pacino");
        System.out.printf("actor %s %s inserted with id %d\n", actor.getFirstName(), actor.getLastName(), actor.getActorId());
        t.addActorToMovies(rFilms, actor);
    }
    
    public TestJPA() {
        emf = Persistence.createEntityManagerFactory("TestJPAPU");
        em = emf.createEntityManager();
    }

    private void testMisc() {
        short actorId = 12;
        Actor a = em.find(Actor.class, actorId);       
        System.out.println("actor is " + a.getFirstName() + " " + a.getLastName());
        
        short filmId = 32;
        Film f = em.find(Film.class, filmId);
        System.out.println("film is " + f.getTitle() + ", in language " + f.getLanguageId().getName());

        short langId = 2;
        Language lang = em.find(Language.class, langId);
        System.out.println("language is " + lang.getName());

        /*
        System.out.printf("Film %s contains actors: \n", f.getTitle());
        Collection<FilmActor> actorsByFilm = f.getFilmActorCollection();
        for (FilmActor af : actorsByFilm) {
            Actor ac = af.getActor();
            System.out.println("Actor: " + ac.getFirstName() + " " + ac.getLastName());
        }
        */
        
        System.out.println("Films in english");
        Query query = em.createNamedQuery("Film.findByLangId");
        query.setParameter("langId", em.find(Language.class, (short) 1));
        List<Film> filmsByLanguage = query.getResultList();
        for (Film film : filmsByLanguage) {
            System.out.println("film: " + film.getTitle());
        }
        /*
        System.out.printf("Actor %s %s has starred in: \n", a.getFirstName(), a.getLastName());
        Collection<FilmActor> filmsByActor = a.getFilmActorCollection();
        for (FilmActor fa : filmsByActor) {
        System.out.println("Film: " + fa.getFilm().getTitle());
        }
        */
        
        query = em.createNamedQuery("Language.findByName");
        query.setParameter("name", "Albanian");
        Language alb = (Language) query.getSingleResult();
        em.getTransaction().begin();
        em.remove(alb);
        em.getTransaction().commit();
    }

    private List<Film> testSelect(String rating) {
        Query query = em.createNamedQuery("Film.findByRating");
        query.setParameter("rating", rating);
        List<Film> films = query.getResultList();
        return films;
    }

    private void testUpdate(List<Film> rFilms) {
        if (rFilms == null)
            return;
        em.getTransaction().begin();
        for (Film film : rFilms) {
            film.setTitle(film.getTitle().toLowerCase());
            em.persist(film);
        }
        em.getTransaction().commit();
    }

    private Actor testNewActor(String name, String surname) {
        Actor actor = new Actor();
        actor.setFirstName(name);
        actor.setLastName(surname);
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        em.refresh(actor);
        return actor;
    }

    private void addActorToMovies(List<Film> rFilms, Actor actor) {
        if (rFilms == null || actor == null)
            return;
        
        em.getTransaction().begin();
        for (Film film : rFilms) {
            Collection<FilmActor> filmActors = film.getFilmActorCollection();
            FilmActor newFA = new FilmActor();
            FilmActorPK pk = new FilmActorPK();
            pk.setActorId(actor.getActorId());
            pk.setFilmId(film.getFilmId());
            newFA.setFilmActorPK(pk);
            filmActors.add(newFA);
            em.persist(newFA);
        }
        em.getTransaction().commit();
        em.refresh(actor);
    }
    
}
