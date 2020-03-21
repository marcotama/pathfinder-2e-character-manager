package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class FeatFeatRequirementEntityPK : Serializable {

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
        val that = other as FeatFeatRequirementEntityPK
        return feat == that.feat &&
                requiredFeat == that.requiredFeat
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, requiredFeat)
    }
}