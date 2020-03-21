package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "skill_action_trait", schema = "public", catalog = "charactermanager")
@IdClass(SkillActionTraitEntityPK::class)
class SkillActionTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_action_id")
    lateinit var skillAction: SkillActionEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SkillActionTraitEntity
        return skillAction == that.skillAction &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(skillAction, trait)
    }
}