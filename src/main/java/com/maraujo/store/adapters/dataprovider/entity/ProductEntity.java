package com.maraujo.store.adapters.dataprovider.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "product_tb")
public class ProductEntity {
    @Id
    @SequenceGenerator(sequenceName = "product_seq", name = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long registrationCode;
    private String productName;
    private String substrate;
    private String productDescription;
    private double width;
    private double height;
    private Integer quantity;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return registrationCode != null && Objects.equals(registrationCode, that.registrationCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
