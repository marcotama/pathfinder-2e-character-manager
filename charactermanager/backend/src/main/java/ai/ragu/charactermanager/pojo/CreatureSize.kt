package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "creature_size")
class CreatureSize : AbstractJpaPersistable<Long>() {

    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var space: String

    @Column
    lateinit var reachTall: String

    @Column
    lateinit var reachLong: String
}