package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spells_bloodline")
class SpellsBloodline : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spell_list_id")
    lateinit var spellList: SpellList

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill1_id")
    lateinit var skill1: Skill

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill2_id")
    lateinit var skill2: Skill

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_cantrip_id")
    lateinit var grantedCantrip: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_1st_level_spell_id")
    lateinit var granted1StLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_2nd_level_spell_id")
    lateinit var granted2NdLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_3rd_level_spell_id")
    lateinit var granted3RdLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_4th_level_spell_id")
    lateinit var granted4ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_5th_level_spell_id")
    lateinit var granted5ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_6th_level_spell_id")
    lateinit var granted6ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_7th_level_spell_id")
    lateinit var granted7ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_8th_level_spell_id")
    lateinit var granted8ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_9th_level_spell_id")
    lateinit var granted9ThLevelSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initial_spell_id")
    lateinit var initialSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advanced_spell_id")
    lateinit var advancedSpell: Spell

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "greater_spell_id")
    lateinit var greaterSpell: Spell

    @Column
    lateinit var bloodMagic: String

    @Column
    lateinit var description: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column
    lateinit var url: String
}