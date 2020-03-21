package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "item")
class Item : AbstractJpaPersistable<Long>() {

    @Id
    @Column(nullable = false)
    lateinit var id: String

    @Column
    lateinit var category: String

    @Column
    lateinit var name: String

    @Column
    var level: Long = 0

    @Column
    var actions: Long = 0

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