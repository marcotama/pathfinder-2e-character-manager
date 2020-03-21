package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_feat_requirement", schema = "public", catalog = "charactermanager")
@IdClass(FeatFeatRequirementEntityPK::class)
class FeatFeatRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var requiredFeat: FeatEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatFeatRequirementEntity
        return feat == that.feat &&
                requiredFeat == that.requiredFeat
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, requiredFeat)
    }
}