package ai.ragu.charactermanager.pojo;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;

@Entity
@Table(appliesTo = "AncestryAbilityBoosts")
public class AncestryAbilityBoosts {


    @ManyToOne
    @ForeignKey(name = "FK_COUNTRY")
    private String ancestryId;

    @ManyToOne
    @ForeignKey(name = "FK_COUNTRY")
    private String abilityScoreId;

}
