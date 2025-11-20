package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bezeichnung;
    private double preis;

    @ManyToMany
    @JoinTable(
            name = "produkt_lieferant",
            joinColumns = @JoinColumn(name = "produkt_id"),
            inverseJoinColumns = @JoinColumn(name = "lieferant_id")
    )
    private Set<Lieferant> lieferanten;
}
