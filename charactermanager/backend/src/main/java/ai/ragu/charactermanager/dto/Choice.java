package ai.ragu.charactermanager.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Choice {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this choice")
    @ToString.Include
    @EqualsAndHashCode.Include
    protected String code;

    @JsonProperty("description")
    @JsonPropertyDescription("A description for this choice")
    protected String description;

    @JsonProperty("options")
    @JsonPropertyDescription("The options for this choice")
    protected List<String> options;

    @JsonProperty("answers")
    @JsonPropertyDescription("The answer/s selected")
    protected List<String> answers;

    @JsonProperty("numAnswers")
    @JsonPropertyDescription("The number of answers allowed for this choice")
    public abstract int getNumAnswers(CharacterDto characterDto);

    public abstract List<Choice> callback(CharacterDto characterDto);

}
