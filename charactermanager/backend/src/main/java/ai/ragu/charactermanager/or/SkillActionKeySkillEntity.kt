package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "skill_action_key_skill", schema = "public", catalog = "charactermanager")
@IdClass(SkillActionKeySkillEntityPK::class)
class SkillActionKeySkillEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_action_id")
    lateinit var skillAction: SkillActionEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "key_skill_id")
    lateinit var keySkill: SkillEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SkillActionKeySkillEntity
        return skillAction == that.skillAction &&
                keySkill == that.keySkill
    }

    override fun hashCode(): Int {
        return Objects.hash(skillAction, keySkill)
    }
}