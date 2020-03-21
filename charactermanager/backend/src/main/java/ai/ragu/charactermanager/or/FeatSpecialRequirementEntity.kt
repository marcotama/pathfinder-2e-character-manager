package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_special_requirement", schema = "public", catalog = "charactermanager")
class FeatSpecialRequirementEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "special_id")
    lateinit var special: SpecialEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatSpecialRequirementEntity
        return feat == that.feat &&
                special == that.special
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, special)
    }
}