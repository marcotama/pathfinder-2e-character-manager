package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_familiar_requirement", schema = "public", catalog = "charactermanager")
class FeatFamiliarRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatFamiliarRequirementEntity
        return feat == that.feat
    }

    override fun hashCode(): Int {
        return Objects.hash(feat)
    }
}