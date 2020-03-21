package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "armor")
class Armor : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var level: String

    @Column
    lateinit var price: String

    @Column
    lateinit var proficiency: String

    @Column
    lateinit var acBonus: String

    @Column
    lateinit var dexCap: String

    @Column
    lateinit var checkPenalty: String

    @Column
    lateinit var speedPenalty: String

    @Column
    lateinit var strength: String

    @Column
    lateinit var bulk: String

    @Column
    lateinit var armorGroup: String

    @Column
    lateinit var description: String

    @Column
    lateinit var src: String

    @Column
    lateinit var url: String
}