package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "item_trait", schema = "public", catalog = "charactermanager")
@IdClass(ItemTraitEntityPK::class)
class ItemTraitEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    lateinit var item: ItemEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ItemTraitEntity
        return item == that.item &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(item, trait)
    }
}