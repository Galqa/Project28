/**
 *  Написати окремий метод для вибірки за пошуком виразу та в пакеті
 */

package task5a;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

public class Expression {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("authorhelper");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

    @PersistenceContext // приміняється для EntityManager
    private EntityManager entityManager;

    public List<Book> findExpression(String title, String packageName) {
        String query = "SELECT b FROM Book b JOIN b.author a WHERE b.title LIKE :title AND a.packageName LIKE :packageName";
        TypedQuery<Book> typedQuery = entityManager.createQuery(query, Book.class);
        typedQuery.setParameter("title", "%" + title + "%");
        typedQuery.setParameter("packageName", "%" + packageName + "%");
        return typedQuery.getResultList();
    }

    }



