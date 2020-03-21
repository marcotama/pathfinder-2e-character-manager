package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "skill_action")
class SkillAction : AbstractJpaPersistable<Long>() {

    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var trained: String

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