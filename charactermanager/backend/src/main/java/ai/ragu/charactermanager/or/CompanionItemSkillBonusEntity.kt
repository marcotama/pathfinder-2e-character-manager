package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "companion_item_skill_bonus", schema = "public", catalog = "charactermanager")
@IdClass(CompanionItemSkillBonusEntityPK::class)
class CompanionItemSkillBonusEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companion_item_id")
    lateinit var companionItem: CompanionItemEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    lateinit var skill: SkillEntity

    @Column(name = "bonus", nullable = true)
    var bonus: Short = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as CompanionItemSkillBonusEntity
        return companionItem == that.companionItem &&
                skill == that.skill &&
                bonus == that.bonus
    }

    override fun hashCode(): Int {
        return Objects.hash(companionItem, skill, bonus)
    }
}