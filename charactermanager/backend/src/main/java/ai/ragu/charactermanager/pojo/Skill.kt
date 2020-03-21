package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "skill")
class Skill : AbstractJpaPersistable<Long>() {

    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ability_score_id")
    lateinit var abilityScore: AbilityScore
}