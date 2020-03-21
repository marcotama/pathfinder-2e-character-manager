package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "spell_list_item", schema = "public", catalog = "charactermanager")
@IdClass(SpellListItemEntityPK::class)
class SpellListItemEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_list_id")
    lateinit var spellList: SpellListEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: SpellEntity

    @Id
    @Column(name = "level", nullable = false)
    var level: Short = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellListItemEntity
        return level == that.level &&
                spellList == that.spellList &&
                spell == that.spell
    }

    override fun hashCode(): Int {
        return Objects.hash(spellList, spell, level)
    }
}