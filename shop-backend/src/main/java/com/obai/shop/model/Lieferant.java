package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lieferant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @ManyToMany(mappedBy = "lieferanten")
    private Set<Produkt> produkte;
}
