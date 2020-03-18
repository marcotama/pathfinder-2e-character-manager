package ai.ragu.charactermanager.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatSpecialRequirement {

    private long id;
    private String featId;
    private String featCategory;
    private String requiredSpecialId;
    private String requiredSpecialCategory;

}
