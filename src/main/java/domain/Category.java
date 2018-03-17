package domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToOne
    private SubCategory subCategory;

}
