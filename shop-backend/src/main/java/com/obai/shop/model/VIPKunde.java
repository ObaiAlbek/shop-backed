package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VIPKunde extends Geschaeftskunde {

    private double rabattSatz;
    private String personalAccountManager;

    public VIPKunde(String firmenname, String ustId, double rabattSatz, String personalAccountManager) {
        super(firmenname, ustId);
        this.rabattSatz = rabattSatz;
        this.personalAccountManager = personalAccountManager;
    }
}
