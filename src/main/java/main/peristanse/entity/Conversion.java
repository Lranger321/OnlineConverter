package main.peristanse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "conversions")
@Data
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "from_currency", nullable = false)
    private String fromCurrency;

    @Column(name = "to_currency", nullable = false)
    private String toCurrency;

    @Column(name = "amount_from_currency", nullable = false)
    private double fromValue;

    @Column(name = "amount_to_currency", nullable = false)
    private double toValue;

    @Column(name = "USD_value", nullable = false)
    private double usdValue;

    @Column(name = "user_id", nullable = false)
    int user;
}
