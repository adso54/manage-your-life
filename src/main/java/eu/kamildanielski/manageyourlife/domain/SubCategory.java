package eu.kamildanielski.manageyourlife.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToOne
    private Category category;
}
