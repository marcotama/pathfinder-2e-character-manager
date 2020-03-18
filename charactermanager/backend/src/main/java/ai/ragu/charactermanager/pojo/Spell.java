package ai.ragu.charactermanager.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spell {

    private String id;
    private String name;
    private String type;
    private long level;
    private String traditions;
    private String actions;
    private String cast;
    private String description;
    private String shortDescription;
    private String src;
    private String url;

}
