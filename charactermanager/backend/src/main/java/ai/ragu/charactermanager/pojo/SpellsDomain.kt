package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spells_domain")
class SpellsDomain : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advanced_spell_id")
    lateinit var advancedSpell: Spell
}