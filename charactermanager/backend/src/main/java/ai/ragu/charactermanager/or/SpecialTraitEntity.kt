package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "special_trait", schema = "public", catalog = "charactermanager")
@IdClass(SpecialTraitEntityPK::class)
class SpecialTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "special_id")
    lateinit var special: SpecialEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpecialTraitEntity
        return special == that.special &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(special, trait)
    }
}