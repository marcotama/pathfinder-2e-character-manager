package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pet_animal", schema = "public", catalog = "charactermanager")
class PetAnimalEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @Column(name = "size", nullable = true, length = -1)
    lateinit var size: String

    @Column(name = "larger", nullable = true, length = -1)
    lateinit var larger: String

    @Column(name = "melee1", nullable = true, length = -1)
    lateinit var melee1: String

    @Column(name = "melee1Action", nullable = true)
    var melee1Action: Int = 0

    @Column(name = "melee1Dam", nullable = true, length = -1)
    lateinit var melee1Dam: String

    @Column(name = "melee1Type", nullable = true, length = -1)
    lateinit var melee1Type: String

    @Column(name = "melee2", nullable = true, length = -1)
    lateinit var melee2: String

    @Column(name = "melee2Action", nullable = true, length = -1)
    lateinit var melee2Action: String

    @Column(name = "melee2Dam", nullable = true, length = -1)
    lateinit var melee2Dam: String

    @Column(name = "melee2Type", nullable = true, length = -1)
    lateinit var melee2Type: String

    @Column(name = "str", nullable = true)
    var str: Int = 0

    @Column(name = "dex", nullable = true)
    var dex: Int = 0

    @Column(name = "con", nullable = true)
    var con: Int = 0

    @Column(name = "intel", nullable = true)
    var intel: Int = 0

    @Column(name = "wis", nullable = true)
    var wis: Int = 0

    @Column(name = "cha", nullable = true)
    var cha: Int = 0

    @Column(name = "hp", nullable = true)
    var hp: Int = 0

    @Column(name = "skill", nullable = true, length = -1)
    lateinit var skill: String

    @Column(name = "senses", nullable = true, length = -1)
    lateinit var senses: String

    @Column(name = "speed", nullable = true)
    var speed: Int = 0

    @Column(name = "burrow", nullable = true, length = -1)
    lateinit var burrow: String

    @Column(name = "climb", nullable = true, length = -1)
    lateinit var climb: String

    @Column(name = "swim", nullable = true, length = -1)
    lateinit var swim: String

    @Column(name = "fly", nullable = true, length = -1)
    lateinit var fly: String

    @Column(name = "special", nullable = true, length = -1)
    lateinit var special: String

    @Column(name = "support", nullable = true, length = -1)
    lateinit var support: String

    @Column(name = "adv_name", nullable = true, length = -1)
    lateinit var advName: String

    @Column(name = "adv_action", nullable = true)
    var advAction: Int = 0

    @Column(name = "adv_traits", nullable = true, length = -1)
    lateinit var advTraits: String

    @Column(name = "adv_desc", nullable = true, length = -1)
    lateinit var advDesc: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as PetAnimalEntity
        return id == that.id &&
                name == that.name &&
                description == that.description &&
                size == that.size &&
                larger == that.larger &&
                melee1 == that.melee1 &&
                melee1Action == that.melee1Action &&
                melee1Dam == that.melee1Dam &&
                melee1Type == that.melee1Type &&
                melee2 == that.melee2 &&
                melee2Action == that.melee2Action &&
                melee2Dam == that.melee2Dam &&
                melee2Type == that.melee2Type &&
                str == that.str &&
                dex == that.dex &&
                con == that.con &&
                intel == that.intel &&
                wis == that.wis &&
                cha == that.cha &&
                hp == that.hp &&
                skill == that.skill &&
                senses == that.senses &&
                speed == that.speed &&
                burrow == that.burrow &&
                climb == that.climb &&
                swim == that.swim &&
                fly == that.fly &&
                special == that.special &&
                support == that.support &&
                advName == that.advName &&
                advAction == that.advAction &&
                advTraits == that.advTraits &&
                advDesc == that.advDesc &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, description, size, larger, melee1, melee1Action, melee1Dam, melee1Type, melee2, melee2Action, melee2Dam, melee2Type, str, dex, con, intel, wis, cha, hp, skill, senses, speed, burrow, climb, swim, fly, special, support, advName, advAction, advTraits, advDesc, src, url)
    }
}