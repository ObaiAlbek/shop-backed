package com.obai.shop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rechnung {
	@Builder.Default
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate rechnungsDatum;
    private String rechnungsNummer;

    @Enumerated(EnumType.STRING)
    private Rechnungsstatus status;

    @Enumerated(EnumType.STRING)
    private Zahlungsart zahlungsart;

    @ManyToOne
    @JoinColumn(name = "kunde_id", nullable = false)
    private Kunde kunde;

    @OneToMany(mappedBy = "rechnung", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rechnungsposition> positionen = new ArrayList<>();

    public void addPosition(Rechnungsposition position) {
        positionen.add(position);
        position.setRechnung(this);
    }
}
