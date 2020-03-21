package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class SpellTraitEntityPK : Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: SpellEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellTraitEntityPK
        return spell == that.spell &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(spell, trait)
    }
}