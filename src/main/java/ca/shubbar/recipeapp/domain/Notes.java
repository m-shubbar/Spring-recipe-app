package ca.shubbar.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-24
 */

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // No need to specify a cascade here
    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
