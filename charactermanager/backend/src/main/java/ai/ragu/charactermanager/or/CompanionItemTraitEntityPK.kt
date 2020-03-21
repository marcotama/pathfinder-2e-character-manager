package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class CompanionItemTraitEntityPK : Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companion_item_id")
    lateinit var companionItem: CompanionItemEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as CompanionItemTraitEntityPK
        return companionItem == that.companionItem &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(companionItem, trait)
    }
}