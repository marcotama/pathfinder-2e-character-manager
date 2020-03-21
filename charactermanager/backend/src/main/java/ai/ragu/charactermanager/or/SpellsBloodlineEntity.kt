package ai.ragu.charactermanager.or

import ai.ragu.charactermanager.pojo.Skill
import ai.ragu.charactermanager.pojo.SpellList
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "spells_bloodline", schema = "public", catalog = "charactermanager")
class SpellsBloodlineEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
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
    lateinit var grantedCantrip: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_1st_level_spell_id")
    lateinit var granted1StLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_2nd_level_spell_id")
    lateinit var granted2NdLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_3rd_level_spell_id")
    lateinit var granted3RdLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_4th_level_spell_id")
    lateinit var granted4ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_5th_level_spell_id")
    lateinit var granted5ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_6th_level_spell_id")
    lateinit var granted6ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_7th_level_spell_id")
    lateinit var granted7ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_8th_level_spell_id")
    lateinit var granted8ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granted_9th_level_spell_id")
    lateinit var granted9ThLevelSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initial_spell_id")
    lateinit var initialSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advanced_spell_id")
    lateinit var advancedSpell: SpellEntity

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "greater_spell_id")
    lateinit var greaterSpell: SpellEntity

    @Column(name = "blood_magic", nullable = true, length = -1)
    lateinit var bloodMagic: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @Column(name = "src", nullable = true, length = -1)
    lateinit var src: String

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellsBloodlineEntity
        return id == that.id &&
                name == that.name &&
                spellList == that.spellList &&
                skill1 == that.skill1 &&
                skill2 == that.skill2 &&
                grantedCantrip == that.grantedCantrip &&
                granted1StLevelSpell == that.granted1StLevelSpell &&
                granted2NdLevelSpell == that.granted2NdLevelSpell &&
                granted3RdLevelSpell == that.granted3RdLevelSpell &&
                granted4ThLevelSpell == that.granted4ThLevelSpell &&
                granted5ThLevelSpell == that.granted5ThLevelSpell &&
                granted6ThLevelSpell == that.granted6ThLevelSpell &&
                granted7ThLevelSpell == that.granted7ThLevelSpell &&
                granted8ThLevelSpell == that.granted8ThLevelSpell &&
                granted9ThLevelSpell == that.granted9ThLevelSpell &&
                initialSpell == that.initialSpell &&
                advancedSpell == that.advancedSpell &&
                greaterSpell == that.greaterSpell &&
                bloodMagic == that.bloodMagic &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, spellList, skill1, skill2, grantedCantrip, granted1StLevelSpell, granted2NdLevelSpell, granted3RdLevelSpell, granted4ThLevelSpell, granted5ThLevelSpell, granted6ThLevelSpell, granted7ThLevelSpell, granted8ThLevelSpell, granted9ThLevelSpell, initialSpell, advancedSpell, greaterSpell, bloodMagic, description, src, url)
    }
}