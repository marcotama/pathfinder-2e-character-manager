package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "magic_armor", schema = "public", catalog = "charactermanager")
class MagicArmorEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true)
    var level: Int = 0

    @Column(name = "price", nullable = true)
    var price: Int = 0

    @Column(name = "identity", nullable = true, length = -1)
    lateinit var identity: String

    @Column(name = "potency", nullable = true)
    var potency: Int = 0

    @Column(name = "resilient", nullable = true)
    var resilient: Int = 0

    @Column(name = "action0", nullable = true, length = -1)
    lateinit var action0: String

    @Column(name = "action0desc", nullable = true, length = -1)
    lateinit var action0Desc: String

    @Column(name = "action1", nullable = true, length = -1)
    lateinit var action1: String

    @Column(name = "action1desc", nullable = true, length = -1)
    lateinit var action1Desc: String

    @Column(name = "rune", nullable = true, length = -1)
    lateinit var rune: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as MagicArmorEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                price == that.price &&
                identity == that.identity &&
                potency == that.potency &&
                resilient == that.resilient &&
                action0 == that.action0 &&
                action0Desc == that.action0Desc &&
                action1 == that.action1 &&
                action1Desc == that.action1Desc &&
                rune == that.rune &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, price, identity, potency, resilient, action0, action0Desc, action1, action1Desc, rune, description, src, url)
    }
}