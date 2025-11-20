package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rechnungsposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int menge;
    private double einzelPreis;

    @ManyToOne
    @JoinColumn(name = "rechnung_id")
    private Rechnung rechnung;

    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

	public void setRechnung(Rechnung rechnung2) {
		this.rechnung = rechnung2;
	}
}
