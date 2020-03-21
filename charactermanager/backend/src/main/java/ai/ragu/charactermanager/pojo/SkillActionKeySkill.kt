package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "skill_action_key_skill")
class SkillActionKeySkill : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_action_id")
    lateinit var skillAction: SkillAction

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "key_skill_id")
    lateinit var keySkill: Skill
}