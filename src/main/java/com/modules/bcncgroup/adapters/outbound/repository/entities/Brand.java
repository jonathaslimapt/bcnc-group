package com.modules.bcncgroup.adapters.outbound.repository.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BRAND")

public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "NAME")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Price> prices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
