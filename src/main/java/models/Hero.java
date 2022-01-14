package models;
//for JDBC only

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Hero {
    private long id;
    @Size(min = 4, max = 14)
    private String name;
    @Min(1)
    @Max(30)
    private int level;
    @NotNull
    private String ultimate;

    public Hero(Long id, String name, int level, String ultimate ){
        this.id = id;
        this.name = name;
        this.level = level;
        this.ultimate = ultimate;
    }

    public Hero( ){ }
}
