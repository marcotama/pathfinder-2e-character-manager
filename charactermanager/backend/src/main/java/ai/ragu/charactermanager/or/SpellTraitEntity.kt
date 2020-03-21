package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "spell_trait", schema = "public", catalog = "charactermanager")
@IdClass(SpellTraitEntityPK::class)
class SpellTraitEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: SpellEntity

    @Column(name = "trait", nullable = false, length = -1)
    @Id
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellTraitEntity
        return spell == that.spell &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(spell, trait)
    }
}