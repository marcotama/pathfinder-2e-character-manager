package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "weapon", schema = "public", catalog = "charactermanager")
class WeaponEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true, length = -1)
    lateinit var level: String

    @Column(name = "price", nullable = true)
    var price: Int = 0

    @Column(name = "weapon_proficiency", nullable = true)
    var weaponProficiency: Int = 0

    @Column(name = "ranged", nullable = true, length = -1)
    lateinit var ranged: String

    @Column(name = "damage", nullable = true)
    var damage: Int = 0

    @Column(name = "damage_type", nullable = true, length = -1)
    lateinit var damageType: String

    @Column(name = "range", nullable = true, length = -1)
    lateinit var range: String

    @Column(name = "reload", nullable = true, length = -1)
    lateinit var reload: String

    @Column(name = "bulk", nullable = true, length = -1)
    lateinit var bulk: String

    @Column(name = "hands", nullable = true, length = -1)
    lateinit var hands: String

    @Column(name = "group", nullable = true, length = -1)
    lateinit var group: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @OneToMany(
            mappedBy = "weapon",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<WeaponTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as WeaponEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                price == that.price &&
                weaponProficiency == that.weaponProficiency &&
                ranged == that.ranged &&
                damage == that.damage &&
                damageType == that.damageType &&
                range == that.range &&
                reload == that.reload &&
                bulk == that.bulk &&
                hands == that.hands &&
                group == that.group &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, price, weaponProficiency, ranged, damage, damageType, range, reload, bulk, hands, group, src, url)
    }
}