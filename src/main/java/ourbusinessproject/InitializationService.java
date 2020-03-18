package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InitializationService {
    private EnterpriseProjectService enterpriseProjectService;


    private Project project1E1;
    private Project project2E1;
    private Project project1E2;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    public InitializationService(@Autowired EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    @Transactional
    public void initProjects() {
        initEnterprise1();
        initEnterprise2();

        initAndSaveProject1E1();
        initAndSaveProject1E2();
        initAndSaveProject2E1();

    }

    private void initAndSaveProject1E1() {
        project1E1 = new Project("p1e1","p1 e1 description", enterprise1);
        enterpriseProjectService.save(project1E1);
        enterprise1 = project1E1.getEnterprise();
    }

    private void initAndSaveProject1E2() {
        project1E2 = new Project("p1e2","p1 e2 description", enterprise2);
        enterpriseProjectService.save(project1E2);
        enterprise2 = project1E2.getEnterprise();
    }

    private void initAndSaveProject2E1() {
        project2E1 = new Project("p2e1","p2 e1 description", enterprise1);
        enterpriseProjectService.save(project2E1);
    }

    private void initEnterprise1() {
        enterprise1 = new Enterprise();
        enterprise1.setName("E1");
        enterprise1.setDescription("E1 description");
        enterprise1.setContactName("Paul Durand");
        enterprise1.setContactEmail("paul.durand@e1.com");
    }

    private void initEnterprise2() {
        enterprise2 = new Enterprise();
        enterprise2.setName("E2");
        enterprise2.setDescription("E2 description");
        enterprise2.setContactName("Paul Dupond");
        enterprise2.setContactEmail("paul.dupond@e2.com");
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
