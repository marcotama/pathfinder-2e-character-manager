package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "wearable_item")
class WearableItem : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var level: String

    @Column
    lateinit var actions: String

    @Column
    lateinit var price: String

    @Column
    lateinit var hands: String

    @Column
    lateinit var bulk: String

    @Column
    lateinit var contains: String

    @Column
    lateinit var usage: String

    @Column
    lateinit var amount: String

    @Column
    lateinit var action0: String

    @Column
    lateinit var action0Desc: String

    @Column
    lateinit var action1: String

    @Column
    lateinit var action1Desc: String

    @Column
    lateinit var description: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column
    lateinit var url: String
}