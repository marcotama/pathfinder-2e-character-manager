package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_ability_score_requirement", schema = "public", catalog = "charactermanager")
@IdClass(FeatAbilityScoreRequirementEntityPK::class)
class FeatAbilityScoreRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ability_score_id")
    lateinit var abilityScore: AbilityScoreEntity

    @Column(name = "training_level_id", nullable = true)
    var trainingLevelId: Short = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatAbilityScoreRequirementEntity
        return feat == that.feat &&
                abilityScore == that.abilityScore &&
                trainingLevelId == that.trainingLevelId
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, abilityScore, trainingLevelId)
    }
}