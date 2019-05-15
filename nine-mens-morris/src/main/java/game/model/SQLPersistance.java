package game.model;

import javax.persistence.*;

/**
 * A játék elmentéséért felel.
 */
public class SQLPersistance {

    /**
     * {@code EntityManager} osztály példányosítás.
     */
    private static EntityManager em;

    /**
     * Frissíti a mySQL adatbázist a játékállás alapján.
     * @param gameState az aktuális játékállás osztálya
     */
    public void update_table(GameState gameState){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emf.createEntityManager();
        delete_row();
        add_row(gameState);
        em.close();
        emf.close();

    }

    /**
     * A mySQL adatbázisban elmentett játékállást betölti egy {@code GameState} objektumba.
     * @return az a {@code GameState} objektum, ami fel lett töltve az elmentett játékállással
     */
    public GameState read_table(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emf.createEntityManager();
        GameState gameState= em.find(GameState.class, 2);
        em.close();
        emf.close();
        return gameState;
    }

    /**
     * Törli a mySQL adatbázis azon sorait amelyeknek az id oszlopában 2-es érték szerepel.
     */
    private void delete_row(){
        GameState old_gameState = em.find(GameState.class, 2);
        em.getTransaction().begin();
        em.remove(old_gameState);
        em.getTransaction().commit();
    }

    /**
     * SQL Az aktuális játékállást elmenti mySQL adatbázisba.
     * @param gameState az aktuális játékállás osztálya
     */
    private void add_row(GameState gameState) {
        em.getTransaction().begin();
        em.persist(gameState);
        em.getTransaction().commit();
    }

}
