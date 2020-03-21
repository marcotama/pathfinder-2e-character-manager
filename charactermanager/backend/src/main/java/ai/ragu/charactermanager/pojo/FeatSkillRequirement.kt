package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat_skill_requirement")
class FeatSkillRequirement : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: Feat

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    lateinit var skill: Skill

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_level_id")
    lateinit var trainingLevel: TrainingLevel
}