package io.spring.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Column(name = "image_url")
    @NotBlank
    private String imageURL;

    @JsonIgnore
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
                + ", isActive=" + isActive + "]";
    }

}
