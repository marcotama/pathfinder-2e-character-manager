package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "item_trait")
class ItemTrait : AbstractJpaPersistable<Long>() {
    
    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    lateinit var item: Item
}