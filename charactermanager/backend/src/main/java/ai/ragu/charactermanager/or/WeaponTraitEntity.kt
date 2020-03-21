package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "weapon_trait", schema = "public", catalog = "charactermanager")
@IdClass(WeaponTraitEntityPK::class)
class WeaponTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_id")
    lateinit var weapon: WeaponEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as WeaponTraitEntity
        return weapon == that.weapon &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(weapon, trait)
    }
}