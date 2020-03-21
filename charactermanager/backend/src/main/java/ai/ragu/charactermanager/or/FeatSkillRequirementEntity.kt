package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_skill_requirement", schema = "public", catalog = "charactermanager")
@IdClass(FeatSkillRequirementEntityPK::class)
class FeatSkillRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    lateinit var skill: SkillEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_level_id")
    lateinit var trainingLevel: TrainingLevelEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatSkillRequirementEntity
        return feat == that.feat &&
                skill == that.skill &&
                trainingLevel == that.trainingLevel
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, skill, trainingLevel)
    }
}