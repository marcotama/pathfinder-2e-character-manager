package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "shield", schema = "public", catalog = "charactermanager")
class ShieldEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true)
    var level: Int = 0

    @Column(name = "actions", nullable = true, length = -1)
    lateinit var actions: String

    @Column(name = "price", nullable = true)
    var price: Int = 0

    @Column(name = "hands", nullable = true, length = -1)
    lateinit var hands: String

    @Column(name = "bulk", nullable = true, length = -1)
    lateinit var bulk: String

    @Column(name = "usage", nullable = true, length = -1)
    lateinit var usage: String

    @Column(name = "ac", nullable = true)
    var ac: Int = 0

    @Column(name = "speed", nullable = true, length = -1)
    lateinit var speed: String

    @Column(name = "hardness", nullable = true)
    var hardness: Int = 0

    @Column(name = "hp", nullable = true)
    var hp: Int = 0

    @Column(name = "action0", nullable = true, length = -1)
    lateinit var action0: String

    @Column(name = "action0desc", nullable = true, length = -1)
    lateinit var action0Desc: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @OneToMany(
            mappedBy = "shield",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<ShieldTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ShieldEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                actions == that.actions &&
                price == that.price &&
                hands == that.hands &&
                bulk == that.bulk &&
                usage == that.usage &&
                ac == that.ac &&
                speed == that.speed &&
                hardness == that.hardness &&
                hp == that.hp &&
                action0 == that.action0 &&
                action0Desc == that.action0Desc &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, actions, price, hands, bulk, usage, ac, speed, hardness, hp, action0, action0Desc, description, src, url)
    }
}