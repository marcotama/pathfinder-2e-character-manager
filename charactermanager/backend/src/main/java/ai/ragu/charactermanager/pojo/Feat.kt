package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat")
class Feat : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var category: String

    @Column
    lateinit var name: String

    @Column
    var level: Long = 0

    @Column
    lateinit var actions: String

    @Column
    lateinit var description: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column
    lateinit var url: String
}