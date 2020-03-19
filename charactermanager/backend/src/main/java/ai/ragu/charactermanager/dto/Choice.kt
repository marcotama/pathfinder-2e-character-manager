package ai.ragu.charactermanager.dto

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
abstract class Choice {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this choice")
    @ToString.Include
    @EqualsAndHashCode.Include
    protected var code: String? = null
    @JsonProperty("description")
    @JsonPropertyDescription("A description for this choice")
    protected var description: String? = null
    @JsonProperty("options")
    @JsonPropertyDescription("The options for this choice")
    protected var options: List<String>? = null
    @JsonProperty("answers")
    @JsonPropertyDescription("The answer/s selected")
    protected var answers: List<String>? = null

    @JsonProperty("numAnswers")
    @JsonPropertyDescription("The number of answers allowed for this choice")
    abstract fun getNumAnswers(characterDto: CharacterDto): Int

    abstract fun callback(characterDto: CharacterDto): List<Choice?>
}