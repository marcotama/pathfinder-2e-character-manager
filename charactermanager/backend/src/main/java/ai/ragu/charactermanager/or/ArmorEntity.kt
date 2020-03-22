package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "armor", schema = "public", catalog = "charactermanager")
class ArmorEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true, length = -1)
    lateinit var level: String

    @Column(name = "price", nullable = true, length = -1)
    lateinit var price: String

    @Column(name = "proficiency", nullable = true, length = -1)
    lateinit var proficiency: String

    @Column(name = "ac_bonus", nullable = true, length = -1)
    lateinit var acBonus: String

    @Column(name = "dex_cap", nullable = true, length = -1)
    lateinit var dexCap: String

    @Column(name = "check_penalty", nullable = true, length = -1)
    lateinit var checkPenalty: String

    @Column(name = "speed_penalty", nullable = true, length = -1)
    lateinit var speedPenalty: String

    @Column(name = "strength", nullable = true, length = -1)
    lateinit var strength: String

    @Column(name = "bulk", nullable = true, length = -1)
    lateinit var bulk: String

    @Column(name = "armor_group", nullable = true, length = -1)
    lateinit var armorGroup: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @OneToMany(
            mappedBy = "armor",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<ArmorTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ArmorEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                price == that.price &&
                proficiency == that.proficiency &&
                acBonus == that.acBonus &&
                dexCap == that.dexCap &&
                checkPenalty == that.checkPenalty &&
                speedPenalty == that.speedPenalty &&
                strength == that.strength &&
                bulk == that.bulk &&
                armorGroup == that.armorGroup &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, price, proficiency, acBonus, dexCap, checkPenalty, speedPenalty, strength, bulk, armorGroup, description, src, url)
    }
}