package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "feat_special_requirement")
class FeatSpecialRequirement : AbstractJpaPersistable<Long>() {

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feat_id")
    lateinit var feat: Feat

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "special_id")
    lateinit var special: Special
}