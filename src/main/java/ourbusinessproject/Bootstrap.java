package ourbusinessproject;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
