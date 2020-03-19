package ai.ragu.charactermanager.pojo;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AbilityScore")
@Getter
@Setter
public class AbilityScore {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
