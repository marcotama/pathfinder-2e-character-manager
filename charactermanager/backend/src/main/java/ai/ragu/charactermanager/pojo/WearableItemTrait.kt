package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "wearable_item_trait")
class WearableItemTrait : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wearable_item_id")
    lateinit var wearableItemId: WearableItem

    @Column
    lateinit var trait: String
}