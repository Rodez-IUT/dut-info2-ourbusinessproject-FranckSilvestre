package ourbusinessproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String title;
    private String description;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
        this.enterprise.getProjects().add(this);
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }
}
