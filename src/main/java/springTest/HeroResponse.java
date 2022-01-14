package springTest;

import lombok.Getter;

@Getter
public class HeroResponse {
    private final String hero;

    public HeroResponse() {
        hero = "";
    }
}
