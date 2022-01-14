package models;
//For Hibernate
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name = "heroes")
public class NewHero {
    @Id
    @NotNull
    private long id;
    @Size(min = 4, max = 14)
    private String name;
    @Min(1)
    @Max(30)
    private int level;
    @NotNull
    private String ultimate;

    public NewHero(Long id, String name, int level, String ultimate ){
        this.id = id;
        this.name = name;
        this.level = level;
        this.ultimate = ultimate;
    }

    public NewHero( ){ }
}
