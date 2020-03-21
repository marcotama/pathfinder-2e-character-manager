package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class WearableItemTraitEntityPK : Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wearable_item_id")
    lateinit var wearableItem: WearableItemEntity

    @Id
    @Column(name = "trait", nullable = false, length = -1)
    lateinit var trait: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as WearableItemTraitEntityPK
        return wearableItem == that.wearableItem &&
                trait == that.trait
    }

    override fun hashCode(): Int {
        return Objects.hash(wearableItem, trait)
    }
}