package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "shield_trait", schema = "public", catalog = "charactermanager")
@IdClass(ShieldTraitEntityPK::class)
class ShieldTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shield_id")
    lateinit var shield: ShieldEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ShieldTraitEntity
        return shield == that.shield &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(shield, trait)
    }
}