package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "companion_item", schema = "public", catalog = "charactermanager")
class CompanionItemEntity {

    lateinit var id: String
    lateinit var name: String
    lateinit var level: String
    lateinit var actions: String
    lateinit var price: String
    lateinit var hands: String
    lateinit var bulk: String
    lateinit var contains: String
    lateinit var usage: String
    lateinit var amount: String
    lateinit var action0: String
    lateinit var action0Desc: String
    lateinit var action1: String
    lateinit var action1Desc: String
    lateinit var description: String
    lateinit var src: RulesSourceEntity
    lateinit var url: String
    lateinit var speed: String
    lateinit var traits: Set<CompanionItemTraitEntity>
    lateinit var skillBonuses: Set<CompanionItemSkillBonusEntity>

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