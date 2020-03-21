package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spell_list_item")
class SpellListItem : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_list_id")
    lateinit var spellList: SpellList

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: Spell

    @Column
    var level: Long = 0
}