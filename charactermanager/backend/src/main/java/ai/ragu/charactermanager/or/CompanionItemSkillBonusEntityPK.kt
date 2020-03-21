package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class CompanionItemSkillBonusEntityPK : Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companion_item_id")
    lateinit var companionItem: CompanionItemEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    lateinit var skill: SkillEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as CompanionItemSkillBonusEntityPK
        return companionItem == that.companionItem &&
                skill == that.skill
    }

    override fun hashCode(): Int {
        return Objects.hash(companionItem, skill)
    }
}