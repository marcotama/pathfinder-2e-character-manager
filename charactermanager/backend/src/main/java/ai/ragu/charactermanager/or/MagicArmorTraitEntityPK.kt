package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class MagicArmorTraitEntityPK : Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magic_armor_id")
    lateinit var magicArmor: MagicArmorEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as MagicArmorTraitEntityPK
        return magicArmor == that.magicArmor &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(magicArmor, trait)
    }
}