package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "skill", schema = "public", catalog = "charactermanager")
class SkillEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ability_score_id")
    lateinit var abilityScore: AbilityScoreEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SkillEntity
        return id == that.id &&
                name == that.name &&
                abilityScore == that.abilityScore
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, abilityScore)
    }
}