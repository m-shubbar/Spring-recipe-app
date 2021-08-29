package ca.shubbar.recipeapp.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-24
 */
@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
