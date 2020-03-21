package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat_trait", schema = "public", catalog = "charactermanager")
@IdClass(FeatTraitEntityPK::class)
class FeatTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: FeatEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatTraitEntity
        return feat == that.feat &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(feat, trait)
    }
}