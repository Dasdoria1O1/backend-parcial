package main.java.com.ejemplo.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Data;

@Data
@Entity
@Table(name = "entities")
@SQLDelete(sql = "UPDATE entities SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean deleted = false;
}

