package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "spells_domain", schema = "public", catalog = "charactermanager")
class SpellsDomainEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: SpellEntity

    @Column(name = "advanced_spell_id", nullable = true, length = -1)
    lateinit var advancedSpellId: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellsDomainEntity
        return id == that.id &&
                name == that.name &&
                spell == that.spell &&
                advancedSpellId == that.advancedSpellId
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, spell, advancedSpellId)
    }
}