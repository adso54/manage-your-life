package eu.kamildanielski.manageyourlife.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;
    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SubCategory subCategory;
}
