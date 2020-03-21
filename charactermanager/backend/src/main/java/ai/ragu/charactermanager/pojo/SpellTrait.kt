package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spell_trait")
class SpellTrait : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_id")
    lateinit var spell: Spell

    @Column
    lateinit var trait: String
}