package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "companion_item_trait", schema = "public", catalog = "charactermanager")
@IdClass(CompanionItemTraitEntityPK::class)
class CompanionItemTraitEntity {

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
        val that = other as CompanionItemTraitEntity
        return companionItem == that.companionItem &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(companionItem, trait)
    }
}