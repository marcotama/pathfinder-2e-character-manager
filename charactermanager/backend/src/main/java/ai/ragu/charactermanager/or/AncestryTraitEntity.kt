package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ancestry_trait", schema = "public", catalog = "charactermanager")
@IdClass(AncestryTraitEntityPK::class)
class AncestryTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: AncestryEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryTraitEntity
        return ancestry == that.ancestry &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestry, trait)
    }
}