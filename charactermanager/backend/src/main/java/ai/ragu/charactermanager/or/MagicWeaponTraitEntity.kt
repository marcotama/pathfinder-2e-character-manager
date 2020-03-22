package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "magic_weapon_trait", schema = "public", catalog = "charactermanager")
@IdClass(MagicWeaponTraitEntityPK::class)
class MagicWeaponTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magic_weapon_id")
    lateinit var magicWeapon: MagicWeaponEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as MagicWeaponTraitEntity
        return magicWeapon == that.magicWeapon &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(magicWeapon, trait)
    }
}