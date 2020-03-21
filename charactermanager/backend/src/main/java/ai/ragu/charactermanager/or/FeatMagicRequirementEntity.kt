package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_magic_requirement", schema = "public", catalog = "charactermanager")
@IdClass(FeatMagicRequirementEntityPK::class)
class FeatMagicRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_level_id")
    lateinit var trainingLevel: TrainingLevelEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatMagicRequirementEntity
        return feat == that.feat &&
                trainingLevel == that.trainingLevel
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, trainingLevel)
    }
}