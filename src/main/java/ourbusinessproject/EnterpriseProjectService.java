package ourbusinessproject;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Project project) {
        entityManager.persist(project.getEnterprise());
        entityManager.persist(project);
        entityManager.flush();
    }

    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
        entityManager.flush();
    }

    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }

    public Project findProjectByTitle(String inTitle) throws Exception {
        String query = "SELECT p FROM Project p WHERE p.title = :title" ;
        TypedQuery<Project> queryObj = entityManager.createQuery(query,Project.class);
        queryObj.setParameter("title", inTitle);
        List<Project> projects = queryObj.getResultList();
        if (projects.size() == 1) {
            return projects.get(0);
        } else if(projects.size() >1) {
            throw new Exception("More than one project with title.");
        } else {
            return null;
        }
    }

    public Enterprise findEnterpriseByName(String inName) throws Exception {
        String query = "SELECT ent FROM Enterprise ent WHERE ent.name = :name" ;
        TypedQuery<Enterprise> queryObj = entityManager.createQuery(query,Enterprise.class);
        queryObj.setParameter("name", inName);
        List<Enterprise> enterprises = queryObj.getResultList();
        if (enterprises.size() == 1) {
            return enterprises.get(0);
        } else if(enterprises.size() >1) {
            throw new Exception("More than one enterprise with name.");
        } else {
            return null;
        }
    }


    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title" ;
        TypedQuery<Project> queryObj = entityManager.createQuery(query,Project.class);
        return queryObj.getResultList();
    }
}
