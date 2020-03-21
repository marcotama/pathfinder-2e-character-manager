package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ability_score")
class AbilityScore : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var description: String
}