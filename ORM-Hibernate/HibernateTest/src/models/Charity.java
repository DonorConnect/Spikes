package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CHARITY")
public class Charity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Project> projects = new ArrayList<Project>();

    public Charity() {

    }

    public Charity(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void addProject(Project newProject) {
        this.projects.add(newProject);
    }

}
