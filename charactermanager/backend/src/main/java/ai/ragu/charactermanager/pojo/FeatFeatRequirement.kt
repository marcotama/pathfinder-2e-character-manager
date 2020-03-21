package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat_feat_requirement")
class FeatFeatRequirement : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: Feat

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "required_feat_id")
    lateinit var requiredFeat: Feat
}