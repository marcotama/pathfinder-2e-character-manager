package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat_magic_requirement")
class FeatMagicRequirement : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: Feat

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_level_id")
    lateinit var trainingLevel: TrainingLevel
}