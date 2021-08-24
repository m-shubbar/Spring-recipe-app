package ca.shubbar.recipeapp.domain;

import javax.persistence.*;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-24
 */
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String uof) {
        this.description = uof;
    }

}
