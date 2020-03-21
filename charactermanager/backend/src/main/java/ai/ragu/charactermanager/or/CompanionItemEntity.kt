package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "companion_item", schema = "public", catalog = "charactermanager")
class CompanionItemEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true, length = -1)
    lateinit var level: String

    @Column(name = "actions", nullable = true, length = -1)
    lateinit var actions: String

    @Column(name = "price", nullable = true, length = -1)
    lateinit var price: String

    @Column(name = "hands", nullable = true, length = -1)
    lateinit var hands: String

    @Column(name = "bulk", nullable = true, length = -1)
    lateinit var bulk: String

    @Column(name = "contains", nullable = true, length = -1)
    lateinit var contains: String

    @Column(name = "usage", nullable = true, length = -1)
    lateinit var usage: String

    @Column(name = "amount", nullable = true, length = -1)
    lateinit var amount: String

    @Column(name = "action0", nullable = true, length = -1)
    lateinit var action0: String

    @Column(name = "action0desc", nullable = true, length = -1)
    lateinit var action0Desc: String

    @Column(name = "action1", nullable = true, length = -1)
    lateinit var action1: String

    @Column(name = "action1desc", nullable = true, length = -1)
    lateinit var action1Desc: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @Column(name = "speed", nullable = true, length = -1)
    lateinit var speed: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as CompanionItemEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                actions == that.actions &&
                price == that.price &&
                hands == that.hands &&
                bulk == that.bulk &&
                contains == that.contains &&
                usage == that.usage &&
                amount == that.amount &&
                action0 == that.action0 &&
                action0Desc == that.action0Desc &&
                action1 == that.action1 &&
                action1Desc == that.action1Desc &&
                description == that.description &&
                src == that.src &&
                url == that.url &&
                speed == that.speed
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, actions, price, hands, bulk, contains, usage, amount, action0, action0Desc, action1, action1Desc, description, src, url, speed)
    }
}